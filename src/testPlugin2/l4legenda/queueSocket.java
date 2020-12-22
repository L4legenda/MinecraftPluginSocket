package testPlugin2.l4legenda;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class queueSocket extends Thread {
	
	ServerSocket serverSocket;
	InetAddress ip;
	Socket socket;
	int port = 8052;
	

	@Override
	public void run() {

		
    	
    	try {
    		
    		
    		ip = InetAddress.getLocalHost();
    		
    		serverSocket = new ServerSocket();
    		serverSocket.bind(new InetSocketAddress(ip.getHostAddress(), port));
    		
    		System.out.println("Start Socket on " + ip.getHostAddress() + " port: " + String.valueOf(port));
    		
    		while(!isInterrupted()) {
    			socket = serverSocket.accept();
    			socket.setKeepAlive(true);
    			System.out.println("Connect");
    			
    			
    			Client client = new Client(socket);
    			client.start();
    		}
    		
    		
    		
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
		}
		
	}
	
	
	public void close() {
		try {
			serverSocket.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
