# Network Visualization Java Program-

2 self-organizing datasets were created in the project to have numbers or symbols rearrange themselves into an interesting shape and being able to witness the entire process through animation.
 
The program utilizes an Object-Oriented StdDraw Library with several shapes that will be used in the animation, mine were (Ellipse, point, line, circle, square, rectangle).
  
The main program NetworkVis.java reads data from a file. Suppose you have created a file called circle.txt, then you may run the program at the command line as: java NetworkVis < circle.txt

For my input files, I created a hexagonal flower and a star. 
 
The text file containing the data is a simple programming language with symbols indicating the appearance of the final organized shape through connected nodes. For example, a line that reads 1 2 connects the first and second symbols at the top of the file.
 
The data can organize due to the computeForces method in NetworkVis which change in coordinates of the data point due to repulsive and attractive forces and then updates the position to create an animation and the Redraw class determines the graphics associated with the datafile.
 

