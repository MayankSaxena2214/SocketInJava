package Setup;


import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class EchoServer {
	public static void main(String[]args) {
		try {
			System.out.println("Waiting for client");
			ServerSocket ss=new ServerSocket(9806);
			Socket soc=ss.accept();
			System.out.println("Client Connected");
			//reading the string which client has passed using  Buffered REader
			//NOTE the client use system.in to read the keyboard input 
			//but the server used the soc.getInputStream to read the data from 
			//socket not from keyboard
			BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String str=in.readLine();
			//now we will send the string back to the client
			PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
			out.println("Server says:"+str);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

