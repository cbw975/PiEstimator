/**
  * Description: A thread class for the PiEstimator class; uses MC simulation to store the
  * number of points/samples that lie inside a (unit) disk inscribed in the square in a 
  * shared (across threads) array
  * 
  * @author Chloe Wohlgemuth
*/
import java.util.concurrent.ThreadLocalRandom;

class PiThread implements Runnable {
    private long numPoints = 0;                // number of samples or points
    private int id;                            // thread id
    private long[] array;                      // array for storing thread value

    /** Constructor. Takes @param numPoints number of samples for MC, @param id thread ID
     * or index, and @param array for storing/sharing thread's computed value */
    public PiThread(long numPoints, int id, long[] array){
        this.numPoints = numPoints; 
        this.id = id;
        this.array = array;
    }
    
    /** Generates many random sample points (i.e. pairs of numbers) lying inside a square and
     * stores (in @var array) the number of samples that lie inside a disk inscribed in the 
     * square. */
    public void run () {
        long pointsInCircle = 0; // number of points that fall in inscribed circle
        for(int i=0; i<numPoints; i++){ // sampling all the points
            double x = ThreadLocalRandom.current().nextDouble(); //coord position of point
            double y = ThreadLocalRandom.current().nextDouble(); //coord position of point
            if( x*x+y*y <= 1){ //point location is in circle (radius 1)
                pointsInCircle += 1;
            }
        }
        array[id] = pointsInCircle; // set estimated pi value at my ID's index
    }
}