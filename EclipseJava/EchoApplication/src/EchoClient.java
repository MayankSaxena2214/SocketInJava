
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Client Started");
			Socket soc=new Socket("localhost",9806);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}