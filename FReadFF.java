import java.io.*;
import java.util.*;
class FReadFF
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
            b = new byte[5];
            int n =fin.read(b,0,5);
            while(n!=0)
            {
                String data = new String(b,0,n);
                System.out.print(data);
                n =fin.read(b,0,n);
            }
            fin.close();
        } 
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
    }
}