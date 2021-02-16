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
    private int numThreads = 1; // number of threads (to distribute samples over)

    /** Constructor. Takes @param numPoints number of sample points and @param numThreads
     * number of threads used to compute the estimate */
    public PiEstimator (long numPoints, int numThreads) {
	    this.numPoints = numPoints;
        this.numThreads = numThreads;
    }

    /** Computes the estimate of pi
     * Generates many random sample points (i.e. pairs of numbers) lying inside a square and 
     * @return the number of samples that lie inside a disk inscribed in the square. Pi can
     * be estimated from the proportion of sample that fall in the disk. */
    public double getPiEstimate () {
	    ...
    }
}