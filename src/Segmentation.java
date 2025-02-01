import java.awt.Rectangle;
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

public class Segmentation {
	
	//function for segmentation return type is list of matrix
	public void segmentation() {
		
		  try {
		      // Loading the OpenCV core library
		      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

		      // Reading the Image from the file and storing it in to a Matrix object
		      String file ="C:\\Users\\Ajmal\\Downloads\\opencv\\FakeCurrencyDetection\\threshbinaryreview.jpg";
		      Mat src = Imgcodecs.imread(file,CvType.CV_8UC1);
		      
		    /*  //drawing rectangle on ROI
		      Imgproc.rectangle(src, new Point(573,571), new Point(771,989),new Scalar(0,255,0),8);
		      Imgproc.rectangle(src, new Point(266,1120), new Point(788,1268),new Scalar(0,255,0),8);
		      Imgproc.rectangle(src, new Point(145,300), new Point(1085,489),new Scalar(0,255,0),8);
		      Imgproc.rectangle(src, new Point(2200,1149), new Point(3189,1313),new Scalar(0,255,0),8);
		      Imgproc.rectangle(src, new Point(3311,695), new Point(3419,787),new Scalar(0,255,0),8);
		      Imgproc.rectangle(src, new Point(3001,621), new Point(3149,869),new Scalar(0,255,0),8);
		      Imgproc.rectangle(src, new Point(2025,93), new Point(3201,197),new Scalar(0,255,0),8);
		      Imgproc.rectangle(src, new Point(1939,117), new Point(2031,1261),new Scalar(0,255,0),8);
		      Imgproc.rectangle(src, new Point(2521,269), new Point(2997,813),new Scalar(0,255,0),8); //watermark(change required)
		    	 Rect roi1 = new Rect(65,625,(265-65),(761-625));	//100 in floral
			     Rect roi2 = new Rect(225,801,(377-225),(997-801));	//hidden 100
			     Rect roi3 = new Rect(65,765,(233-53),(917-765));		//id mark
			     Rect roi4 = new Rect(305,1161,(1313-305),(1349-1161));	//serial no left
			     Rect roi5 = new Rect(2553,41,(3517-2553),(245-41));	//serial no right
			     Rect roi6 = new Rect(1061,157,(2285-1061),(301-157)); //RBI mark
			     Rect roi7 = new Rect(245,341,(941-245),(1069-341));	//watermark
			     Rect roi8 = new Rect(2025,1,(2227-2025),(1410-1));		//security thread
			  */
		      
		      //extracting ROI
			     Rect roi1 = new Rect(65,625,(353-65),(780-625));	//100 in floral
			     Rect roi2 = new Rect(260,760,(360-260),(947-760));	//hidden 100
			     Rect roi3 = new Rect(128,800,(255-128),(905-800));		//id mark
			     Rect roi4 = new Rect(305,1161,(1313-305),(1349-1161));	//serial no left
			     Rect roi5 = new Rect(2553,41,(3517-2553),(245-41));	//serial no right
			     Rect roi6 = new Rect(1061,157,(2285-1061),(301-157)); //RBI mark
			     Rect roi7 = new Rect(349,407,(1015-349),(1027-407));	//watermark
			     Rect roi8 = new Rect(2085,1,(2285-2085),(1410-1));		//security thread
			   //  Rect roi9 = new Rect(2605,301,(3101-2605),(873-301)); //watermark(change required)
			     
		     
		     
		     
		     List<Mat> feature = new ArrayList();
		     
		     feature.add(0, src.submat(roi1));
		     feature.add(1, src.submat(roi2));
		     feature.add(2, src.submat(roi3));
		     feature.add(3, src.submat(roi4));
		     feature.add(4, src.submat(roi5));
		     feature.add(5, src.submat(roi6));
		     feature.add(6, src.submat(roi7));
		     feature.add(7, src.submat(roi8));
//		     feature.add(8, src.submat(roi9));
		      
		      StringBuilder str=new StringBuilder("try1");
		      
		      
		      // Writing the image
		     for(int i=0;i<feature.size();i++)
		     	{
		    	//str.append(i); 
		    	str.deleteCharAt(3);
		    	str.append(i);
		   //		System.out.println(str);
		   		Imgcodecs.imwrite("C:\\Users\\Ajmal\\Downloads\\opencv\\FakeCurrencyDetection\\"+str+".jpg",feature.get(i));
		     	}     
				
		     Imgcodecs.imwrite("C:\\Users\\Ajmal\\Downloads\\opencv\\FakeCurrencyDetection\\allcontours.jpg",src);
		     
		 //   System.out.println("Image Processed ");
		   }catch (Exception e) {
		       System.out.println("Error: " + e.getMessage());
		    }

	}
}
