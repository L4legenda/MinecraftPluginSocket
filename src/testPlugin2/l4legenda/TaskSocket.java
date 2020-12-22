package testPlugin2.l4legenda;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskSocket extends Thread {

	@Override
	public void run() {
		try {
			
			ServerSocket server = new ServerSocket();
			server.bind(new InetSocketAddress("192.168.0.105", 8052));
			
			System.out.println(InetAddress.getLocalHost().getHostAddress() + ", 8052");
			
			
           Socket client = server.accept(); // The client is the sender.
           client.setKeepAlive(true);
           
           InputStream in = client.getInputStream();
           BufferedReader reader = new BufferedReader(new InputStreamReader(in));
           
           String s = null;
           //Creating String for reading
           if((s = reader.readLine()) != null){
               //Reading the line out of the Socket and printing it out
               System.out.println("Received: " + s);
           }
           in.close();
           reader.close();
           client.close();
	       
			
			
		
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
