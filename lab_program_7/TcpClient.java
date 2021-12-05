import java.net.*;
import java.io.*;
import java.util.*;
public class TcpClient
{
    public static void main(String args[])throws IOException
    {
        try
        {
            Socket con= new Socket("localhost",95);
            BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
            PrintWriter out=new PrintWriter(con.getOutputStream(),true);
            while(true)
            {
                System.out.print("enter the message to the server:");
                BufferedReader din=new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter 5 nums");
                int a[]=new int[5];
                for(int i=0;i<5;i++)
                {
                    a[i]=Integer.parseInt(din.readLine());
                }
                String st=Arrays.toString(a);
                out.println(st);
                String s1=in.readLine();
                System.out.println("from server:"+s1);
                if(st.equalsIgnoreCase("bye")||st==null)
                    break;
            }
            in.close();
            out.close();
            con.close();
        }
        catch(UnknownHostException e)
        {
        }
    }
}

