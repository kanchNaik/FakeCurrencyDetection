import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import java.io.File;
import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class GrayScale {
	//function for converting colored image into gray scale
	public void grayImage() {
		   try {
			   			  System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			   	         
			   			  //load the input file
			   			  File input = new File("adjustment.jpg");
			   			  
			   			  //convert the image file into buffered stream
			   	         BufferedImage image = ImageIO.read(input);	

			   	         //get data about RGB (three channel data)
			   	         byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			   	         
			   	         //convert byte data to mat
			   	         Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
			   	         mat.put(0, 0, data);
			   	         
			   	         //convert RGB into Gray image

			   	         Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
			   	         Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);

			   	         
			   	         //converting Mat data to byte stream
			   	         byte[] data1 = new byte[mat1.rows() * mat1.cols() * (int)(mat1.elemSize())];
			   	         mat1.get(0, 0, data1);
			   	         BufferedImage image1 = new BufferedImage(mat1.cols(),mat1.rows(), BufferedImage.TYPE_BYTE_GRAY);
			   	         image1.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), data1);

			   	         //create new empty file
			   	         File ouptut = new File("grayscale.jpg");
			   	         
			   	         //write image mat in file
			   	         ImageIO.write(image1, "jpg", ouptut);

			   				        
		 }
			catch (Exception e) {
	         System.out.println("Error: " + e.getMessage());
			}
	}
   
		
}
