import java.awt.Color;
import java.util.InputMismatchException;


public class Ellipse extends Figure {
	protected double themajoraxis;  // the major axis
	protected double theminoraxis;  // the minor axis   

    protected boolean filled;    // filled or not                                                 
 
    public Ellipse() { // default constructor                                                    
         super();        // make sure to create the *whole* object                               
	     themajoraxis = 0;  
	     theminoraxis = 0;                                                  
         filled = false; // default is not filled                                                
         }
 
     public void setAxis(double majoraxis, double minoraxis) {
    	 // error checking, but not handled directly 
         if (majoraxis < 0) {
          throw new InputMismatchException("Invaid input " + majoraxis);
          } 

          themajoraxis = majoraxis;          

         if (minoraxis < 0 ) {                            
            throw new InputMismatchException("Invaid input " + minoraxis);       
         }
         theminoraxis = minoraxis; 
         }
 
     public double getArea() {
         return themajoraxis * theminoraxis * Math.PI;
         }
 
     public void setFilled(boolean f) {
         filled = f;
         }
 
     public void draw() { // this implements the abstract method of figure
         Color savedColor = StdDraw.getPenColor(); // leave no footprint                         
         StdDraw.setPenColor(theColor);
         if (filled)
        	 StdDraw.filledEllipse(theX, theY, themajoraxis, theminoraxis); 
      
         else
             StdDraw.ellipse(theX, theY, themajoraxis, theminoraxis);
             StdDraw.setPenColor(savedColor);          // restore the old color                      
    }

  }