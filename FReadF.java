import java.io.*;
import java.util.*;
class FReadF
{
	public static void main(String args[])
    {
        FileInputStream fin;
	    Scanner s = new Scanner(System.in);
	    String fname;
        try
        {
            System.out.println("Enter the Filename : ");
            fname=s.nextLine();
            fin=new FileInputStream(fname);
            byte b[];
            b = new byte[fin.available()];
            fin.read();
            String data = new String(b,0,b.length);
            System.out.println(data);
            fin.close();
        } 
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
    }
}