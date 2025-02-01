import org.opencv.core.Size;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Adjustment {

	//function to adjust image dimensions
	 public Mat adjustImage(Mat source) {
		 //mat to store the result
	       Mat resizeImage = new Mat();
		 
	       try {
			   System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		        
	          //Mat croppedimage = cropImage(image,rect);
			   
			   //create filter for resizing
	          Size sz = new Size(3576,1412);
	          
	          //resize the image
	          Imgproc.resize( source, resizeImage, sz );  

	        
		 }
			catch (Exception e) {
	         System.out.println("Error: " + e.getMessage());
			}
	       
	       //return resized image
		  return resizeImage;
	 }

}
