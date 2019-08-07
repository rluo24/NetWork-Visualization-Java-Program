/*************************************************************************                                                                     
 *                                                                                              
 *  This inherits from the Ellipse class.                                                        
 *************************************************************************/
 import java.awt.Color;
 import java.util.InputMismatchException;
 // A circle is a particular type of Ellipse                                                   
 public class Circle extends Ellipse{
                                                                                                 
     public Circle() { // default constructor                                                    
         super();        // make sure to create the *whole* object                               

         }
 
     public void setRadius(double radius) {
         if (radius < 0) // error checking, but not handled directly                             
             throw new InputMismatchException("Invaid input " + radius);

         themajoraxis = radius; // makes major axis and minor axis the same number ( the radius) and uses methods in Ellipse to make a circle 
         theminoraxis = radius; 
     }
 }
 
   
   
