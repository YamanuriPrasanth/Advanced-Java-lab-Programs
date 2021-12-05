import java.net.*;
import java.io.*;
import java.util.*;
public class TcpServer 
{
public static void main(String args[])throws IOException
{
try
{
//Server scoket creation with default ip address and port no 95
ServerSocket s= new ServerSocket(95);
System.out.println("Server Waiting for the Client");
//waiting for client requests
Socket cs=s.accept();
//Fetching client address and displaying
InetAddress ie=cs.getInetAddress();
String cli=ie.getHostAddress();
System.out.println("Connected to the client with IP "+cli);
//creating in object on client socket for read 
BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
//creating out object on clinet socket for write
PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
do
{ 
//reading(recieving) data from client(if no data from client waits till data is ready)
String st=in.readLine();
//converting into array
String c[]=st.replaceAll("\\[","").replaceAll("]","").replaceAll(" ","").split(",");
		
		int n[]=new int[c.length];
		for(int i=0;i<c.length;i++){
			n[i]=Integer.valueOf(c[i]);
		}
//sorting
TcpServer ts=new TcpServer();
ts.sort(n);
String res=Arrays.toString(n);
//writing(sending) data to client
out.println(res);
if(st.equalsIgnoreCase("bye")||st==null)
break;
//printing data from client on console
System.out.println("from client.  "+st);
}while(true);
//closing all streams opened
in.close();
out.close();
cs.close();
}
catch(IOException e)
{
}

}

void sort(int n[]){
	int i,j,temp;
	int l=n.length;
	for(i=0;i<l-1;i++){
		for(j=0;j<l-i-1;j++){
			if(n[j]>n[j+1]){
				temp=n[j];
				n[j]=n[j+1];
				n[j+1]=temp;
			}
		}
	}
}

}

