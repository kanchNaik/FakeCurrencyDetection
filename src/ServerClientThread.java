

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.xml.ws.handler.MessageContext;

import org.omg.CORBA_2_3.portable.InputStream;
import org.opencv.imgcodecs.Imgcodecs;

public class ServerClientThread extends Thread{
	
	Socket serverClient;
	int clientNo;
	
	ServerClientThread(Socket inSocket,int counter){
		serverClient = inSocket;
		clientNo=counter;
	 }

	public void run(){
		String clientMessage="",servermessage="";
		try{
			   DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
		       ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		       DataInputStream dIn = new DataInputStream(serverClient.getInputStream());
		       
		       int length = dIn.readInt();                    // read length of incoming message
		       byte[] message = new byte[length];
		       if(length>0) {
		           dIn.readFully(message, 0, message.length); // read the message
		       }
		       
		       bos.write(message, 0, message.length);
		       byte[] bytes = bos.toByteArray();
		       
		       ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		       Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
		 
		       ImageReader reader = (ImageReader) readers.next();
		       Object source = bis; 
		       ImageInputStream iis = ImageIO.createImageInputStream(source); 
		       reader.setInput(iis, true);
		       ImageReadParam param = reader.getDefaultReadParam();
		 
		       Image image = reader.read(0, param);
		       //got an image file
		 
		       BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		       //bufferedImage is the RenderedImage to be written
		 
		       Graphics2D g2 = bufferedImage.createGraphics();
		       g2.drawImage(image, null, null);
		 
		       StringBuilder str=new StringBuilder("client"+clientNo);
		       String fileName=str.toString();
		       
		       File imageFile = new File("C:\\Users\\Ajmal\\Downloads\\opencv\\FakeCurrencyDetection\\"+str+".jpg");
		       ImageIO.write(bufferedImage, "jpg", imageFile);
		 
		       FakeCurrencyDetection fcd=new FakeCurrencyDetection();
		       servermessage=fcd.takinginput(str);
		       
		       outStream.writeUTF(servermessage);

		 //    inStream.close();
		       outStream.close();
		       
		       serverClient.close();
		   }catch(Exception ex){
		     System.out.println(ex);
		   }
		   finally{
		     System.out.println("Client -" + clientNo + " exit!! ");
		   }
		 }
	 
}
	 