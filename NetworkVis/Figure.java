/*************************************************************************                      
 *  Compilation:  javac Figure.java                                                             
 *  Dependencies: StdDraw.java,                                                                 
 *                                                                                              
 *  This is the super class for all the figures of StdDraw                                      
 *                                                                                              
 *************************************************************************/
import java.awt.Color;
 
// A figure is any type of drawing object.                                                      
// But by itself is meaningless                                                                 
// The keyword "abstract" makes it uninstantiable.                                              
 public abstract class Figure {
 
     protected double theX;   // the x-coordinate                                                
     protected double theY;   // the y-coordinate                                                
     protected Color theColor; // the color of the figure                                        
 
     protected Figure() { 
        // default constructor                                                                  
         theX = 0;
         theY = 0;
         theColor = Color.BLACK;
     }

     protected double getX() { return theX; }
     protected double getY() { return theY; }
 
     protected void setPosition(double x, double y) {
         theX = x;
         theY = y;
     }
     protected void setColor(Color color) {
         theColor = color;
     }
 
     protected Color getColor() {
         return theColor;
     }
 
      abstract void draw();
}
