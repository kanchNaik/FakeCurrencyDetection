import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class FinfContours {
	
	//function for finding contours
	 public Mat findContours(Mat source) {
		 
		 //matrix which stores image with contour detected
		 Mat contourImage = new Mat(source.rows(),source.cols(),source.type());
		   
		 try {
			  
			   System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

		
			        Mat heiarchy = new Mat();

			      List<MatOfPoint> contours = new ArrayList<MatOfPoint>();

			      //finding contours 
			      Imgproc.findContours(source, contours,heiarchy,Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
			     			      int count=0;
			      
			     // System.out.println(contours);
			     // System.out.println("hi");
			      
			     	//get total no of contours found		      
			      int x=contours.size();
			      System.out.println(x);
			      
			      //drawing bounding rectangle on each contour
			    	  for(int i=0; i< contours.size();i++)
				      {
			    		  //select the contours whose area is greater than 100
			    		  if (Imgproc.contourArea(contours.get(i)) > 100)
			    		  {
			    			  //rectangle storing contour
			    		      Rect rect = Imgproc.boundingRect(contours.get(i));
			    		      
			    		      //drawing contour if height is more than 20 and width more than 30
			    		       if ((rect.height > 20 || rect.width > 30))
			    		      {
			    		    	  count++;
			    		    	  System.out.println(Imgproc.contourArea(contours.get(i))+" " +rect.x +" " +rect.y+" " +rect.width+" "+rect.height);
			    		    	  Imgproc.rectangle(source, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,255,0),8);
			    		      }
			    		  }    		 
				      }
			    	  
			      
			   

			      System.out.println("Image Processed "+count);

		 }
			catch (Exception e) {
	         System.out.println("Error: " + e.getMessage());
			}
		 
		 //return the image with contours
		  return source;
	 }


}
