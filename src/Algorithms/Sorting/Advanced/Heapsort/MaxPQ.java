package Algorithms.Sorting.Advanced.Heapsort;
import java.lang.Comparable;
import Algorithms.Sorting.Sort;

public class MaxPQ extends Sort {
    private Comparable[] pq;
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
     */
    public Comparable read(){
        // Return the first element of the array
        return pq[1];
    }
    /**
     * Delete the element of the heap with more priority
     * and return it.
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
        sink(1);
        return max;
    }
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i,int j){
        Comparable t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    /**
     * Sort the priority of the array
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
    public void buildBU( Comparable[] a){
        if( a.length < pq.length ){
            n = a.length;
            for( int i = 0; i < a.length; i++ )
                pq[i+1] = a[i];
            for( int i = n/2; i >= 1; i-- )
                sink(i);
        }
    }
}
