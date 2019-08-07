/*************************************************************************                      
                         
 *  compilation: javac NetworkVis.java                                                          
 *  execution: java NetworkVis < input.txt   (star.txt and hexagon.txt)                                                                                                 
 *                                                                                              
                                                            
 *    ...                                                                                       
 *************************************************************************/
 
import java.util.Scanner;
 
public class NetworkVis {
 
    private static final double KR = 0.01;   // Constants                                       
    private static final double KA = 0.005;
 
    private static int N; // the number of nodes                                                
    private static Node[] nodes;
    private static boolean[][] network;
 
    private static double minX = 0, minY = 0, maxX = 0, maxY = 0; // canvas size            
 
    public static void setup() {
        StdDraw.enableDoubleBuffering();
 
        Scanner input = new Scanner(System.in);
        N = input.nextInt();                         // number of nodes                
        nodes = new Node[N];
        network = new boolean[N][N];                 // 2d array of connections        
 
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(Math.random(), Math.random(), input.next());
            // The line above is equivalent to the next three lines:                            
            // nodes[i] = new Node();                                                           
            // nodes[i].setPosition(Math.random(), Math.random());                              
            // nodes[i].setLabel(input.next());                                                 
        }
 
        while (input.hasNext()) {
            int i = input.nextInt();
            int j = input.nextInt();
            network[i][j] = true;
            network[j][i] = true;
        }
    }
 
   public static void computeForces() {
        for (int i = 0; i < N; i++) {         // each node i                                
            for (int j = i + 1; j < N; j++) { // each node j, avoiding symmetric pairs   
                double x0 = nodes[i].getX();
                double y0 = nodes[i].getY();
                double x1 = nodes[j].getX();
                double y1 = nodes[j].getY();
 
                double delX = 0.0;
                double delY = 0.0;
 
                //distance between points i and j                                               
                double r = Math.sqrt(((x1-x0) * (x1-x0)) + ((y1-y0) * (y1-y0)));
                //angle                                                                         
                double theta = Math.atan2((y1 - y0), (x1 - x0));
                if (network[i][j]) {
                    //change in coordinates due to attractive force                             
                    delX += KA * r * r * Math.cos(theta);
                    delY += KA * r * r * Math.sin(theta);
                }
                if (Math.abs(r) > 0.00001) {
                    //change in coordinates due to repulsive force                              
                    delX += (-1.0) * (KR / r) * Math.cos(theta);
                    delY += (-1.0) * (KR / r) * Math.sin(theta);
                }
                // update the changes in x and y                                                
                nodes[i].setDelta(nodes[i].getDX()+delX, nodes[i].getDY()+delY);
                nodes[j].setDelta(nodes[j].getDX()-delX, nodes[j].getDY()-delY);
            }
        }
    }
 
    public static void updatePositions() {
        // update the position of each node                                                     
        for (int count = 0; count < N; count++) {
            nodes[count].setPosition(nodes[count].getX()+nodes[count].getDX(),
                                     nodes[count].getY()+nodes[count].getDY());
 
            nodes[count].setDelta(0,0);
 
            if (nodes[count].getX() > maxX) maxX = nodes[count].getX();
            if (nodes[count].getX() < minX) minX = nodes[count].getX();
 
            if (nodes[count].getY() > maxY) maxY = nodes[count].getY();
            if (nodes[count].getY() < minY) minY = nodes[count].getY();
        }
    }
 
 // new shapes implemented 
    public static void redraw() {
        // reset the canvas size to account for the new node positions                          
        StdDraw.setXscale(minX-5,maxX+5);
        StdDraw.setYscale(minY-5,maxY+5);
        StdDraw.clear();
        // draw the nodes                                                                       
        for (int i = 0; i < N; i++) {
             String label = nodes[i].getLabel();

             if (label.equals(".")) {                            
                Circle cir = new Circle();
                cir.setFilled(true); 
                cir.setColor(StdDraw.BLACK);
                cir.setPosition(nodes[i].getX(),nodes[i].getY());
                cir.setRadius(5);
                cir.draw();

             for ( int j = 0 ; j < 5 ; j ++){

             Square squ1 = new Square();
             squ1.setColor(StdDraw.BLUE); 
             squ1.setPosition(nodes[i].getX(),nodes[i].getY());
             squ1.setSide(6 + j );
             squ1.draw(); 

             }

             }

             if (label.equals ("-")){ 

              Square squ = new Square (); 
              squ.setFilled(true); 
              squ.setColor(StdDraw.BLACK); 
              squ.setPosition(nodes[i].getX(),nodes[i].getY());
              squ.setSide(5.5);
              squ.draw();

             }
             
             if (label.equals ("+")){


              Ellipse eli = new Ellipse (); 
              eli.setColor(StdDraw.ORANGE); 
              eli.setPosition(nodes[i].getX(),nodes[i].getY());
              eli.setAxis(5, 4);
              eli.draw();

             }
 
             else {

             Circle cir1 = new Circle(); // circle around the numbers/ letters
             cir1.setColor(StdDraw.WHITE);
             cir1.setFilled(true); 
             cir1.setPosition(nodes[i].getX(),nodes[i].getY());
             cir1.setRadius(.7);
             cir1.draw();


             Circle cir2 = new Circle(); // circle around the numbers/ letters
             cir2.setColor(StdDraw.CYAN); 
             cir2.setPosition(nodes[i].getX(),nodes[i].getY());
             cir2.setRadius(1);
             cir2.draw();

        
                             

             Text item = new Text();
             item.setText(nodes[i].getLabel());
             item.setPosition(nodes[i].getX(),nodes[i].getY());
             item.draw();
             
         }

 }
        //draw the edges -- need the Line class                                                
        for (int i = 0; i < N; i++)                                                          
            for (int j = i + 1; j < N; j++) {                                                
             if (network[i][j]) {                                                            
                 Line line = new Line(); 
                 line.setWidth(0.005) ;                              
                 line.setColor(StdDraw.MAGENTA);                                                
                 line.setEndpoints(nodes[i].getX(),nodes[i].getY(),                          
                                   nodes[j].getX(),nodes[j].getY());                         
                 line.draw();                                                                
             } 

             }                                                                                
 
        // display all of the figures                                                        
        StdDraw.show();
    }
 
    public static void main (String args[]) {
        int numIterations = 1000; // default                                                    
        if (args.length >= 1)
            try {
                // number of times to run the force-based algorithm                             
                numIterations = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {}
 
        setup();
        for (int numIndex = 0; numIndex < numIterations; numIndex++) {
            computeForces();
            updatePositions();
            redraw();
            StdDraw.pause(10);
        }
    }
}
