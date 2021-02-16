/**
  * Description: A thread class for the PiEstimator class.
  *
  * @author Chloe Wohlgemuth
*/

import java.util.concurrent.ThreadLocalRandom;

public class PiThread implements Runnable {
    public static final int numThreads = 4;  // number of threads to run
    private long numSamples = 0;

    public PiThread(numSamples){
        this.numSamples = numSamples;
    }

    public void run () {
        
    }

}