 /*************************************************************************                                                                           
 *                                                                                              
 *  This inherits from the Figure class.                                                        
 *************************************************************************/


 import java.awt.Color;
 import java.util.InputMismatchException;

 public class Rectangle extends Figure {

	 protected double thelength;  // the length (protected because Square also need access to these varibles)
	 protected double thewidth;  // the width   

     protected boolean filled;    // filled or not                                                 
 
     public Rectangle() {  // default constructor                                                    
         super();        // make sure to create the *whole* object                               
	     thelength = 0;  
	     thewidth = 0;                                                  
         filled = false; // default is not filled                                                
         }
 
     public void setSide(double length, double width) {
    	 // error checking, but not handled directly 
         if (length < 0) {
          throw new InputMismatchException("Invaid input " + length);
         } 
          
         if (width < 0 ) {                            
            throw new InputMismatchException("Invaid input " + width);       
         }

         thelength = length;
         thewidth = width; 
         }
 
     public double getArea() {
         return thelength * thewidth; 
         }
 
     public void setFilled(boolean f) {
         filled = f;
         }
 
     public void draw() { // this implements the abstract method of figure
         Color savedColor = StdDraw.getPenColor(); // leave no footprint                         
         StdDraw.setPenColor(theColor);
         if (filled)
        	 StdDraw.filledRectangle(theX, theY, thewidth, thelength); 
      
         else
             StdDraw.rectangle(theX, theY, thewidth, thelength);
             StdDraw.setPenColor(savedColor);          // restore the old color                      
             }


             }