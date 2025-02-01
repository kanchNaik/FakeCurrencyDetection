import org.opencv.core.Size;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Smoothening{
	//function for smoothening the image
	 public Mat smoothImage(Mat source) {
		 
		 //mat to store the smoothened the image 
	       Mat smoothImage = new Mat(source.rows(),source.cols(),source.type());
		 
	       try {
			   //define kernel size
			   int kernelSize = 9;
			   System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		        
	         //smooth the image using median blur
			   
		         //Imgcodecs.imwrite("outputsmoothening.jpg", destination);
			     

	        
		 }
			catch (Exception e) {
	         System.out.println("Error: " + e.getMessage());
			}
		  return smoothImage;
	 }

}

