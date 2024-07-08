package Setup;
import java.net.Socket;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Client Started");
			Socket soc=new Socket("localhost",9806);
			BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
			//system.in can read the one byte of data at a time but we don't want to read 
//the byte directly so we will take help from the class inputstreamreader it takes the input
//as byte stream and return the character stream . We don't want to deal with the one by one
//character ,so to get the entire character stream we use BufferedReader ,i.e it will read he 
//entire string
			System.out.println("Enter a string");
			String str=userInput.readLine();
			//now we have the string which we want to sent to server so we will use printWriter 
			PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
			//we passed a boolean value true,because when the next time we use the printWriter 
			//object then it will automatically clear out the prevous data
			out.println(str);
			//Now the server will received it and sent back to the client with some additional 
			//message
			BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println(in.readLine());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

