package Factorial;

import java.net.Socket;
import java.io.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Client Started");
			Socket soc=new Socket("localhost",9806);
			//we have to read the input from keyboard from user
			//using Buffer reader 
			BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the number");
			int number=Integer.parseInt(userInput.readLine());
			//now to pass the number to server we use the PrintWriter
			PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
			out.println(number);
			BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println(in.readLine());
			
			
		}
		catch(Exception e) {
			System.out.println("Exception handelled"+e);
		}
		
	}

}
