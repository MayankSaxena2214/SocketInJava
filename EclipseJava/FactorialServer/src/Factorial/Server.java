package Factorial;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss=new ServerSocket(9806);
			System.out.println("Waiting for the client");
			Socket soc=ss.accept();
			System.out.println("Conncetion Established");
			BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			int number=Integer.parseInt(in.readLine());
			PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
			out.println("FActorial of "+number+" is"+calculat(number));
			
		}
		catch(Exception e) {
			System.out.println("Exception handelled"+e);
		}
	}
	static int calculat(int number) {
		int ans=1;
		for(int i=1;i<=number;i++) {
			ans*=i;
		}
		return ans;
	}

}
