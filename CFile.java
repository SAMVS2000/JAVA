import java.io.*;
class CFile
{
	public static void main(String args[])
    {
        File f;
        String s[];
        int i;
        try
        {
            f= new File("d:\\");
            s= f.list();
            for (i=0;i<s.length;i++)
            {
                System.out.println(s[i]);
            }
        } 
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
    }
}