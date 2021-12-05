import java.net.*;
import java.io.*;

public class UdpClient 
{
DatagramSocket socket=null;
public UdpClient()
{
}
public void createAndListenSocket()
{
try
{
socket=new DatagramSocket();
InetAddress IpAddress=InetAddress.getByName("localhost");
byte[]incomingData=new byte[1024];
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
while(true){
System.out.print("Message to server: ");
String sentence= br.readLine();
byte[] data= sentence.getBytes();
DatagramPacket sendPacket= new DatagramPacket(data,data.length,IpAddress,9876);
socket.send(sendPacket);
DatagramPacket incomingPacket= new DatagramPacket(incomingData,incomingData.length);
socket.receive(incomingPacket);
String response=new String(incomingPacket.getData());
System.out.println("Response from server:"+response);
}
}

catch(UnknownHostException e)
{
e.printStackTrace();
}
catch(SocketException e)
{
e.printStackTrace();
}
catch(IOException e)
{
e.printStackTrace();
}


}

public static void main(String args[])
{
UdpClient client=new UdpClient();
client.createAndListenSocket();
}
}

