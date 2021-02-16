/**
  * Description: A thread class for the PiEstimator class.
  *
  * @author Chloe Wohlgemuth
*/
import java.util.concurrent.ThreadLocalRandom;

class PiThread implements Runnable {
    private long numPoints = 0;                // number of samples or points
    private int id;                           // thread id
    private long[] array;                      // array

    public PiThread(long numPoints, int id, long[] array){
        this.numPoints = numPoints; 
        this.id = id;
        this.array = array;
    }
    
    public void run () {
        long pointsInCircle = 0; // number of points in inscribed circle
        for(int i=0; i<numPoints; i++){
            double x = ThreadLocalRandom.current().nextDouble(); //coord position of point
            double y = ThreadLocalRandom.current().nextDouble(); //coord position of point
            if( x*x+y*y <= 1){
                pointsInCircle += 1;
            }
        }
        array[id] = pointsInCircle; // set estimated pi value at my ID's index
    }
}