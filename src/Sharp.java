import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Sharp {

	//sharpen the Gray image
	 public void sharpImage() {
		 try{
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         
	         //load the input image
	         Mat source = Imgcodecs.imread("grayscale.jpg",
	        		 Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         
	         //create empty mat to store image
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         
	         //apply filter for sharpening
	         Imgproc.GaussianBlur(source, destination, new Size(0,0), 60);
	         
	         //add weights
	         Core.addWeighted(source, 1.5, destination, -1, 0, destination);
	         
	         //write output
	         Imgcodecs.imwrite("sharpgray.jpg", destination);
	      }catch (Exception e) {
	      }
	 }
}
