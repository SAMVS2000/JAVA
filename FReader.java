import java.io.*;
class FReader
{
	public static void main(String args[])
    {
        FileReader fr;
        BufferReader br;
        try
        {
            fr= new FileReader(new File("a.txt"));
            br= new BufferReader(fr);
            String data = br.readLine();
            while(data!=NULL)
            {
                System.out.println(data);
                data= br.readLine();
            }
            br.close();
        } 
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
    }
}