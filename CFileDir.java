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
            f= new File("d:\\appdata\\");
            s= f.list();
            for (i=0;i<s.length;i++)
            {
                File ff= new File("d:\\appdata\\" + s[i]);
                if(ff.isDirectory())
                {
                    System.out.println(s[i]);
                }
            }
        } 
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
    }
}