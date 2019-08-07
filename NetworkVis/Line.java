/*************************************************************************                                                                            
 *                                                                                              
 *  This inherits from the Figure class.                                                        
 *************************************************************************/
 import java.awt.Color;
 import java.util.InputMismatchException;

 public class Line extends Figure {

	 private double theX2; // private only to this class 
	 private double theY2;  

   
     public Line() {
	     super();
	
	     theX2 = 0; 
	     theY2 = 0; 
         }

     public void setEndpoints(double X1, double Y1, double X2, double Y2){

         if (Math.abs(X1) > 10) {
          throw new InputMismatchException("Invaid input " + X1);  
         }

         if (Math.abs(X2) > 10) {
          throw new InputMismatchException("Invaid input " + X2);  
         }

         if (Math.abs(Y1) > 10) {
          throw new InputMismatchException("Invaid input " + Y1);  
         }

         if (Math.abs(Y2) > 10) {
          throw new InputMismatchException("Invaid input " + Y2);  
         }


    	 theX = X1; 
    	 theY = Y1; 
         theX2 = X2; 
         theY2 = Y2; 
         }

     public void setWidth(double wid){ // changes the thickness of the line 
        StdDraw.setPenRadius(wid); 
     }

     public double getLength (){

         return (Math.sqrt((theX -theX2) * (theX - theX2) + (theY - theY2) * (theY - theY2))); 

         }
 
     public void draw() {
     Color savedColor = StdDraw.getPenColor(); // leave no footprint                         
     StdDraw.setPenColor(theColor);
     StdDraw.line(theX, theY, theX2, theY2);
     }

 }