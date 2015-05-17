package keepon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class KeepOnNetworkClient {

	protected Socket					socket;
	protected PrintWriter				socketOut;
	protected String					hostName;
	protected int						port;
	
	
	public KeepOnNetworkClient(int port){
		this("localhost", port);
	}
	
	public KeepOnNetworkClient(String hostName, int port){
		this.hostName = hostName;
		this.port = port;
	}
	
	public boolean connectToKeepOnServer(){
				
		try{
		
			
			Socket kkSocket = new Socket(this.hostName, this.port);
			PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
			new InputStreamReader(kkSocket.getInputStream()));
			
			
			this.socketOut = out;
			this.socket = kkSocket;
			System.out.println("Connected!");
			//this.socketOut.println("You are welcome - java.");
			return true;
   
           
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
		
		return false;
	}
	
	
	public void say(String text){
		if(this.socketOut == null){
			throw new RuntimeException("Not connected to a server. Use the connectToKeepOnServer() method");
		}
		this.socketOut.println(text);
	}
	
	
	public void closeConnection(){
		if(this.socket != null){
			try {
				this.socket.close();
				this.socket = null;
				this.socketOut = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
