package testPlugin2.l4legenda;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread {
	
	Socket socket;
	String data;
	
	public Client(Socket socket) {
		this.socket = socket; 
		System.out.println(socket.getInetAddress());
	}

	@Override
	public void run() {
		System.out.println("run");
		try {
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
           
           String s = null;
           //Creating String for reading
           if((s = reader.readLine()) != null){
               //Reading the line out of the Socket and printing it out
        	   if(s.equals("weater on")) {
        		   Weather.weater = true;
        	   }
        	   else if(s.equals("weater off")) {
        		   Weather.weater = false;
        	   }
        	   
               System.out.println("Received: " + s);
           }
           in.close();
           reader.close();
			
		}catch (IOException e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	
}
