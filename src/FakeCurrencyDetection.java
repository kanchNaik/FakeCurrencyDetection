import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class FakeCurrencyDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	StringBuilder str=new StringBuilder("client6");
	/*StringBuilder fl=new StringBuilder("20");
	for(int i=0;i<3;i++) {
		int len=fl.length();
    	
		System.out.println("2"+i);
    	
    	fl.deleteCharAt(len-1);
    	fl.append(i);
    	
		takinginput(fl);
		
	}*/
	
	takinginput(str);
	
	}

	

	public static String takinginput(StringBuilder str) {
		
		//Object Define
				Adjustment adj=new Adjustment();
				GrayScale gray=new GrayScale();
				Sharp sharp = new Sharp();
				AdaptiveThresholding athresh= new AdaptiveThresholding();
				Segmentation seg= new Segmentation();
				RandomForest rf=new RandomForest();
				
				String output="";
				System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		         
				//Read the source image
		        Mat source = Imgcodecs.imread(str.toString()+".jpg");
		         
		        //Initialize matrix to store output
		        Mat adjustout=new Mat();
		       
		        //Processing
		        
		        //Image adjustment
		        adjustout=adj.adjustImage(source);
		        Imgcodecs.imwrite("adjustment.jpg", adjustout);
		         
		        //Image GrayScale
		        gray.grayImage();
		        
		        //Sharpening the image in-order to remove noise
		        sharp.sharpImage();
		         
		        //Adaptive thresholding
		        athresh.adaptiveThresh();
		         
		        //Segmentation
		        seg.segmentation();

		        //Random Forest
		        output=rf.Rforest();
		        
		        return output;
	}
}
