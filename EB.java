import java.sql.*;
import java.util.*;

public class EB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        try {
            // Connect to the MySQL database
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs?characterEncoding=UTF-8", "root", "");
            System.out.println("Connected to the database.");

            // Perform user login
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (authenticateUser(conn, username, password)) {
                // Take user input for customer name and units consumed
                System.out.print("Enter customer name: ");
                String customerName = scanner.nextLine();
                System.out.print("Enter units consumed: ");
                int unitsConsumed = scanner.nextInt();

                // Generate electricity bill
                generateElectricityBill(conn, customerName, unitsConsumed);
            } else {
                System.out.println("Invalid username or password. Access denied.");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
            scanner.close();
        }
    }

    public static boolean authenticateUser(Connection conn, String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        boolean isAuthenticated = rs.next();
        rs.close();
        pstmt.close();
        return isAuthenticated;
    }

    public static void generateElectricityBill(Connection conn, String customerName, int unitsConsumed) throws SQLException {
        // Fetch tariff rates from database
        String sql = "SELECT rate FROM tariff_rates ORDER BY id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        double billAmount = 0;
        int unitCounter = 0;
        while (rs.next() && unitsConsumed > 0) {
            double rate = rs.getDouble("rate");
            if (unitsConsumed > 0) {
                int unitsToCalculate = Math.min(unitsConsumed, (unitCounter == 0 ? 100 : (unitCounter == 1 ? 200 : Integer.MAX_VALUE)));
                billAmount += unitsToCalculate * rate;
                unitsConsumed -= unitsToCalculate;
                unitCounter++;
            }
        }

        rs.close();
        stmt.close();

        System.out.println("Electricity Bill for " + customerName + ": $" + billAmount);
    }
}