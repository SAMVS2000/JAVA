import java.io.*;
import java.util.*;
class FWrite
{
	public static void main(String args[])
    {
        FileOutputStream fout;
	    Scanner s = new Scanner(System.in);
	    String fname,data;
        try
        {
            System.out.println("Enter the Filename : ");
            fname=s.nextLine();
            fout=new FileOutputStream(fname);
            System.out.println("Enter data / quit to terminate ");
            data=s.nextLine();
            while(!data.equals("quit"))
            {
                fout.write(data.getBytes());
                data=s.nextLine();
            }
            fout.close();
        } 
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
    }
}