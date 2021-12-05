import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.*;
public class UdpServer
{
    DatagramSocket socket=null;
    public UdpServer()
    {
    }
    public void createAndListenSocket()
    {
        try
        {
            socket=new DatagramSocket(9876);
            byte[]incomingData=new byte[1024];
            while(true)
            {
                DatagramPacket incomingPacket=new DatagramPacket(incomingData,incomingData.length);
                socket.receive(incomingPacket);
                String message= new String(incomingPacket.getData());
                InetAddress IpAddress=incomingPacket.getAddress();
                int port=incomingPacket.getPort();
                System.out.println("Received message from client"+port+":"+message);
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Message to client: ");
                String reply= br.readLine();
                byte[] data= reply.getBytes();
                DatagramPacket replyPacket= new DatagramPacket(data,data.length,IpAddress,port);
                socket.send(replyPacket);
                Thread.sleep(2000);
            }
        }
        catch(SocketException e)
        {
            e.printStackTrace();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        UdpServer server=new UdpServer();
        server.createAndListenSocket();
    }
}

