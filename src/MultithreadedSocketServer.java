import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedSocketServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       
		try{
		     ServerSocket server=new ServerSocket(5010);
		     int counter=0;
		     System.out.println("Server Started ....");
		     while(true){
		       counter++;
		       Socket serverClient=server.accept();  //server accept the client connection request
		       System.out.println(" >> " + "Client No:" + counter + " started!");
		       ServerClientThread sct = new ServerClientThread(serverClient,counter);
		       sct.start();
		     }
		   }catch(Exception e){
		     System.out.println(e);
		   }
		 }
	}