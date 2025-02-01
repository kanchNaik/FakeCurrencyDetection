import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class AdaptiveThresholding {
	
	//function for Adaptive Thresholding
	 public void adaptiveThresh() {
	      try{

	    	  System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

	          // Reading the Image from the file and storing it in to a Matrix object
	          String file ="C:\\Users\\Ajmal\\Downloads\\opencv\\FakeCurrencyDetection/sharpgray.jpg";
	          
	          // Reading the image
	          Mat src = Imgcodecs.imread(file,0);

	          // Creating an empty matrix to store the result
	          Mat dst = new Mat(src.height(), src.width(), CvType.CV_8UC1);
	          Imgproc.adaptiveThreshold(src, dst, 250, Imgproc.ADAPTIVE_THRESH_MEAN_C,
	          Imgproc.THRESH_BINARY, 51, 7);
	          	
	           // Writing the image
	          Imgcodecs.imwrite("C:\\Users\\Ajmal\\Downloads\\opencv\\FakeCurrencyDetection/threshbinaryreview.jpg", dst);

	         // System.out.println("Image Processed");
	         
	      }catch (Exception e) {
	         System.out.println("error: " + e.getMessage());
	      }
	 	 }

}
