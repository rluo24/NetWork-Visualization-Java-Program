/*************************************************************************                      
                                                     
 *                                                                                              
 *  This inherits from the Recrtangle class.                                                        
 *************************************************************************/
 import java.awt.Color;
 import java.util.InputMismatchException;

 public class Square extends Rectangle {

                                          
 public Square() {  // default constructor                                                    
     super();        // make sure to create the *whole* object                                           
     }
 
 public void setSide(double side) {
     // error checking, but not handled directly 
     if (side < 0) {
     throw new InputMismatchException("Invaid input " + side);
     } 

     thelength = side;
     thewidth = side; 
       
     }
     }

 