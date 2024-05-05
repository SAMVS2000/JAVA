import java.io.*;
import java.util.*;
class FCopy
{
	public static void main(String args[])
    {
        FileInputStream fin;
        FileOutputStream fout;
	    Scanner s = new Scanner(System.in);
	    String sf1,df2,data;
        try
        {
            System.out.println("Enter the Source Filename : ");
            sf1=s.nextLine();
            System.out.println("Enter the Destination Filename : ");
            df2=s.nextLine();
            fin= new FileInputStream(sf1);
            fout= new FileOutputStream(df2);
            byte b[];
            b = new byte[5];
            int n= fin.read(b,0,5);
            while(n!=-1)
            {
                fout.write(b,0,n);
                n= fin.read(b,0,5);
            }
            fin.close();
            fout.close();
        } 
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
    }
}