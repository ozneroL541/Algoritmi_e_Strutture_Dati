package Algorithms.Sorting.Advanced.Heapsort;
import java.lang.Comparable;
import Algorithms.Sorting.Sort;

public class MaxPQ extends Sort {
    // Maximum Priority Queue array
    private Comparable[] pq;
    // Lenght of the array
    private int n = 0;
    /**
     * Constructor of Maximum Priority Queue
     * element with lenght dim
     * @param dim lenght
     */
    public MaxPQ ( int dim ){
        this.pq = new Comparable[dim+1];
    }
    /**
     * Check if the heap is empty
     * @return true if heap is empty
     */
    public boolean isEmpty(){
        return n == 0;
    }
    /**
     * Return the size of the array
     * @return lenght of heap
     */
    public int size(){
        return n;
    }
    /**
     * Insert v at the first void space in the array
     * Complexity
     * O(1) best
     * O(log(n)) worst
     * @param v item to insert
     */
    public void insert(Comparable v){
        // Increment the size of heap
        // Assign v to the first void space of the array
        pq[++n] = v;
        // Reorder the array
        swim(n);
    }
    /**
     * Read the element of the heap with more priority
     * @return first element
     * Complexity
     * O(1)
     */
    public Comparable read(){
        // Return the first element of the array
        return pq[1];
    }
    /**
     * Delete the element of the heap with more priority
     * and return it.
     * Complexity
     * O(1) best
     * O(log(n)) worst
     * @return first element
     */
    public Comparable delete(){
        // Copy the first element of the heap
        Comparable max = pq[1];
        // Exchange the first element with the last one
        // and decrease the lenght of heap
        exch(1,n--);
        // Delete the last element of the array
        pq[n+1] = null;
        //
        sink(1);
        return max;
    }
    /**
     * Check if pq[i] is less than pq[j]
     * @param i first index
     * @param j second index
     * @return true if pq[i] is less than pq[j]
     */
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    /**
     * Exchange pq[i] with pq[j]
     * @param i first index
     * @param j second index
     */
    private void exch(int i,int j){
        // Auxiliary variable
        Comparable t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    /**
     * Sort the priority of the array.
     * Complexity
     * O(1) best
     * O(log(n)) worst
     * @param k
     */
    private void swim(int k){
        // While k is more than 1
        // and k/2 is less than k
        while( k > 1 && less( k/2, k ) ){
            // Exchange k/2 with k
            exch(k/2, k);
            // Halve k
            k = k/2;
        }
    }
    /**
     * Sort the array starting with k
     * Complexity
     * O(1) best
     * O(log(n)) worst
     * @param k starting point
     */
    private void sink(int k){
        // While 2*k is less than n
        while( 2*k <= n ){
            // Assign 2*k to j
            int j = 2*k;
            // If j is less than n and
            // j is less than j+1
            if( j < n && less( j, j+1 ) )
                // Increase j
                j++;
            // If k is not less than j
            if( !less( k, j ) )
                // Exit
                break;
            // Exchange k with j
            exch( k, j );
            // Assign j to k
            k = j;
        }
    }
    /**
     * Bottom Up build.
     * Complexity
     * Theta(n)
     * @param a
     */
    public void buildBU( Comparable[] a){
        // If the lenght of a is smaller than pq
        if( a.length < pq.length ){
            // Assign the lenght of a to n
            n = a.length;
            // For every element of a
            for( int i = 0; i < a.length; i++ )
                // Assign a[i] to pq[i+1]
                pq[i+1] = a[i];
            // From n/2 to 1
            for( int i = n/2; i >= 1; i-- )
                // Sink i
                sink(i);
        }
    }
}
