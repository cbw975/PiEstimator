/**
  * Description: A multithreaded program that performs a Monte Carlo simulation to estimate
  * the math constant π. It takes @param numPoints number of samples and @param numThreads
  * number of threads and then computes a π estimate by performing the specified number of
  * samples evenly distributed across the threads.
  *
  * @author Chloe Wohlgemuth
*/
  public class PiEstimator {
    // Fields
    private long numPoints = 0; // number of points or samples
    private int numThreads = 1; // number of threads to run (distribute samples over)
    private double pi; // estimated value of pi


    /** Constructor. Takes @param numPoints number of sample points and @param numThreads
     * number of threads used to compute the estimate */
    public PiEstimator (long numPoints, int numThreads) {
	    this.numPoints = numPoints;
        this.numThreads = numThreads;
        this.pi = 0;
    }

    /** Computes the estimate of pi
     * Generates many random sample points (i.e. pairs of numbers) lying inside a square and 
     * @return the number of samples that lie inside a disk inscribed in the square. Pi can
     * be estimated from the proportion of sample that fall in the disk. */
    public double getPiEstimate () {
        long[] piEstimates = new long[numThreads]; // shared array with an index for each thread
	    Thread[] threads = new Thread[numThreads]; // array of threads

        // Initialize threads with the specified number of samples evenly distributed across
        for(int i=0; i<numThreads; i++){
            threads[i] = new Thread(new PiThread((long)(numPoints/numThreads),i,piEstimates));
        }

        // start all of the threads
        for (Thread t : threads) {
            t.start();
        }

        // wait for all threads to complete
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ignored) {} // don't care if it gets interrupted
        }

        //pi value = sum of points that were made in circle (sum of array) / total number of points * 4
        long pointsInCircle = 0; // number of points in inscribed circle
        for (long e : piEstimates) pointsInCircle += e;
        return (double) pointsInCircle / numPoints * 4.0;
    }
}