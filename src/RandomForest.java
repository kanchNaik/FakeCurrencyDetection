import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.Size;
import org.opencv.core.TermCriteria;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.ml.Ml;
import org.opencv.ml.RTrees;
import java.io.FileReader;
import java.io.BufferedReader;

public class RandomForest {
	public String Rforest(){
		 String output = "";
			try{
			 System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			 Mat trainingTraits = new Mat(100,25,CvType.CV_32FC1);
			 Mat trainingclass = new Mat(100,1,CvType.CV_32S);
			 
			 //input dataset
			 FileReader trainfile = new FileReader("vrushal.csv");
			 BufferedReader br = new BufferedReader(trainfile);
			 int counter=0;
			 String line;
			 double [] a;
			 double [] b;
			
				 if(trainfile!= null)
				 {
				//	 System.out.println("File opened");
					 
					 while ((line = br.readLine()) != null) {
			
						 // use comma as separator
						 String [] feature = line.split(",");
			             
			              for(int col=0;col<25;col++)
			               {
			            	   if(col<24)
			            		   trainingTraits.put(counter,col,Double.valueOf(feature[col]));
			            	   else
			            		  trainingclass.put(counter,0,Integer.valueOf(feature[col]));
			            		   
			               }
			               
			             /*  for(int col=0;col<22;col++)
			               {
			            	   if(col<21)
			            	   {
			            		  a=trainingTraits.get(counter, col);
			          //  		  System.out.println(a[0]);
			            	   }
			            	   else
			            	   {
			            		   b=trainingclass.get(counter,0);
			            //		   System.out.println(b[0]);
			            	   }   
			               }
			               */
			               counter++;
			               
			            }

					 
					 //Training Machine
			    boolean flag;
				// int layout = 5;
				 RTrees rt = RTrees.create();
				 TermCriteria criteria = new TermCriteria(TermCriteria.EPS + TermCriteria.MAX_ITER,100,0.1);
				 rt.setTermCriteria(criteria);
				 rt.setActiveVarCount(5);
				 rt.setCalculateVarImportance(true);
				rt.setMaxCategories(2);
				flag=rt.train(trainingTraits,Ml.ROW_SAMPLE, trainingclass);
				System.out.println(flag); 
				
				//ajmal_vrushal test
				
				MatOfDouble stddev =new MatOfDouble();
				MatOfDouble mean = new MatOfDouble();
				 
				StringBuilder str=new StringBuilder("try0");
			    int count=0;
			    double[] values=new double[24];
			    double meanvalue,stddevvalue,varvalue;  
			      // Writing the image
			     for(int i=0;i<8;i++)
			     	{
			    	
			    	str.deleteCharAt(3);
			    	str.append(i);
			   		//System.out.println(str);
			   		Mat src = Imgcodecs.imread(str+".jpg");
			     	     
				    Core.meanStdDev(src, mean, stddev);
			     
				
				    meanvalue = mean.get(0,0)[0];
				    stddevvalue= stddev.get(0,0)[0];
				    varvalue=stddevvalue*stddevvalue;
				    
				    values[count++]=meanvalue;
				    values[count++]=stddevvalue;
				    values[count++]=varvalue;
				    
				    
			     	}
				
				 Mat testSamples = new Mat(new Size(24,1),CvType.CV_32FC1);
				 for(int i=0;i<24;i++) {

					    System.out.println(values[i]);
					    
					testSamples.put(0,i,values[i]);
				 }
			/*	   testSamples.put(0,0,184.208);
				    testSamples.put(0,1,95.328);
				    testSamples.put(0,2,8766.084);
				    testSamples.put(0,3,162.252);
				    testSamples.put(0,4,118.985);
				    testSamples.put(0,5,14157.443);
				    testSamples.put(0,6,167.538);
				    testSamples.put(0,7,117.232);
				    testSamples.put(0,8,13745.257);
				    testSamples.put(0,9,161.326);
				    testSamples.put(0,10,119.262);
				    testSamples.put(0,11,14223.491);
				    testSamples.put(0,12,190.09);
				    testSamples.put(0,13,106.444);
				    testSamples.put(0,14,11330.509);
				    testSamples.put(0,15,150.2921);
				    testSamples.put(0,16,122.151);
				    testSamples.put(0,17,14920.967);
				    testSamples.put(0,18,182.839);
				    testSamples.put(0,19,110.551);
				    testSamples.put(0,20,12221.706);
				    
				 */
				 
				 
				 
				 
				 
		/*		 testSamples.put(0,0,162.557);
				    testSamples.put(0,1,118.634);
				    testSamples.put(0,2,14107.33);
				    testSamples.put(0,3,180.2283);
				    testSamples.put(0,4,111.1608);
				    testSamples.put(0,5,12013.78);
				    testSamples.put(0,6,176.7241);
				    testSamples.put(0,7,113.2307);
				    testSamples.put(0,8,12537.48);
				    testSamples.put(0,9,164.5188);
				    testSamples.put(0,10,118.2069);
				    testSamples.put(0,11,13975.81);
				    testSamples.put(0,12,181.842);
				    testSamples.put(0,13,110.698);
				    testSamples.put(0,14,12270.93);
				    testSamples.put(0,15,151.739);
				    testSamples.put(0,16,121.7407);
				    testSamples.put(0,17,14822.91);
				    testSamples.put(0,18,183.8797);
				    testSamples.put(0,19,111.1199);
				    testSamples.put(0,20,11713.88);*/
			//    System.out.println("height: " + testSamples.height() + " width: " + testSamples.width());
	
				    //Testing
				 
				 double pp=rt.predict(testSamples);
				    System.out.println("printed:"+ pp);
				    
				   
				    
				 if(pp==1.0) {
					 output="real";
					 System.out.println("Its real");
				 }
				 else {
					 output="fake";
					 System.out.println("its fake");
				 }
				 
				 System.out.println("Value of counter is :" + counter);
			 }
			 else
				 System.out.println("File can not be opened");
		}catch(Exception e){
			 System.out.println("Error: " + e.getMessage());
		}
			return output;
	}

}


/*
public String Rforest(){
String output = "";
	try{
	 System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	 Mat trainingTraits = new Mat(100,21,CvType.CV_32FC1);
	 Mat trainingclass = new Mat(100,1,CvType.CV_32S);
	 
	 //input dataset
	 FileReader trainfile = new FileReader("traindata.csv");
	 BufferedReader br = new BufferedReader(trainfile);
	 int counter=0;
	 String line;
	 double [] a;
	 double [] b;
	
		 if(trainfile!= null)
		 {
			 System.out.println("File opened");
			 
			 while ((line = br.readLine()) != null) {
	
				 // use comma as separator
				 String [] feature = line.split(",");
	             
	              for(int col=0;col<22;col++)
	               {
	            	   if(col<21)
	            		   trainingTraits.put(counter,col,Double.valueOf(feature[col]));
	            	   else
	            		  trainingclass.put(counter,0,Integer.valueOf(feature[col]));
	            		   
	               }
	               
	               counter++;
	               
	            }

			 
			 //Training Machine
	    boolean flag;
		// int layout = 5;
		 RTrees rt = RTrees.create();
		 TermCriteria criteria = new TermCriteria(TermCriteria.EPS + TermCriteria.MAX_ITER,100,0.1);
		 rt.setTermCriteria(criteria);
		 rt.setActiveVarCount(5);
		 rt.setCalculateVarImportance(true);
		 rt.setMaxCategories(2);
		flag=rt.train(trainingTraits,Ml.ROW_SAMPLE, trainingclass);
		 
		
		
		//ajmal_vrushal test
		
		MatOfDouble stddev =new MatOfDouble();
		MatOfDouble mean = new MatOfDouble();
		 
		StringBuilder str=new StringBuilder("try0");
	    int count=0;
	    double[] values=new double[24];
	    double meanvalue,stddevvalue,varvalue;  
	      // Writing the image
	     for(int i=0;i<7;i++)
	     	{
	    	
	    	str.deleteCharAt(3);
	    	str.append(i);
	   		System.out.println(str);
	   		Mat src = Imgcodecs.imread(str+".jpg");
	     	     
		    Core.meanStdDev(src, mean, stddev);
	     
		
		    meanvalue = mean.get(0,0)[0];
		    stddevvalue= stddev.get(0,0)[0];
		    varvalue=stddevvalue*stddevvalue;
		    
		    values[count++]=meanvalue;
		    values[count++]=stddevvalue;
		    values[count++]=varvalue;
		    
		    
	     	}
		
		 Mat testSamples = new Mat(new Size(21,1),CvType.CV_32FC1);
		 for(int i=0;i<21;i++) {

			    System.out.println(values[i]);
			    
			testSamples.put(0,i,values[i]);
		 }
	
		    //Testing
		 
		 double pp=rt.predict(testSamples);
		    System.out.println("printed:"+ pp);
		    
		   
		    
		 if(pp==1.0) {
			 output="real";
			 System.out.println("Its real");
		 }
		 else {
			 output="fake";
			 System.out.println("its fake");
		 }
		 
		 System.out.println("Value of counter is :" + counter);
	 }
	 else
		 System.out.println("File can not be opened");
}catch(Exception e){
	 System.out.println("Error: " + e.getMessage());
}
	return output;
}

}
*/