package Algorithms.Sorting.Advanced.Quicksort;

import Algorithms.Sorting.Sort;
import Data_Structures.List_Stack_Queue.Stack;

public class Quick extends Sort {
    /**
     * The array is divided in elements bigger
     * and smaller than the pivot.
     * @param a array
     * @param l pivot
     * @param r last element of the array
     * @return pivot
     */
    protected static int partition( Comparable[] a, int l, int r ) {
        // Set i as the beginning and j ad the end
        int i = l, j = r + 1;
        // Copy the array in v
        Comparable v = a[l];
        // For ever 
        while ( true ){
            // Increment i and go on if a[i] is less than v
            while ( less( a[++i], v ) )
                // Stop when i reaches r
                if( i == r )
                    break;
            // Decrease j and go on if a[j] is more than v
            while ( less( v, a[--j] ) )
                // Stop when j reaches l
                if( j == l )
                    break;
            // Stop if i is more than j
            if ( i >= j ) 
                break;
            // Exchange i with j
            exch( a, i, j );
        }
        // Exchange l with j
        exch( a, l, j );
        // Return j
        return j;
    }
    /**
     * Execute a recoursive method
     * @param a array of comparables
     */
    public static void sort( Comparable[] a ){
        // Execute the recoursive method
        sort( a, 0, a.length - 1 );
    }
    /**
     * Partition the first part of the array,
     * than recoursively call this method on
     * the first and on the second part of the array.
     * Summing up this method use partition on every
     * element in the array.
     * @param a array
     * @param l lower element of the array
     * @param r higher element of the array
     */
    private static void sort( Comparable[] a, int l, int r ) {
        // Stop if r is lower than l
        if ( r <= l )
            return;
        // Partition the array
        int j = partition( a, l, r );
        // Quicksort the first part of the array
        sort( a, l, j-1 );
        // Quicksort the second part of the array
        sort( a, j+1, r );
    }
    /**
     * Iterative version of Quicksort
     * @param a array
     * @param l lower element of the array
     * @param r higher element of the array
     */
    private static void sortIt( Comparable[] a, int l, int r ){
        int i;
        Stack<Integer> s = new Stack<Integer>();
        // if l is bigger than r stop the execution
        if( l >= r )
            return;
        // Insert l and r in the stack
        s.push(l);
        s.push(r);
        // Whil the stack is not empty
        while( ! s.isEmpty() ){
            // Pop on r
            r = s.top();
            s.pop();
            // Pop on l
            l = s.top();
            s.pop();
            // i equals the return of partition
            i = partition( a, l, r );
            // If i -l is bigger than r - i
            if( i - l > r - i ){
                // Push l
                s.push(l);
                // Push i-1
                s.push(i-1);
                // Push i+1
                s.push(i+1);
                // Push r
                s.push(r);
            }else{
                // Push i+1
                s.push(i+1);
                // Push r
                s.push(r);
                // Push l
                s.push(l);
                // Push i-1
                s.push(i-1);
            }
        }
    }
}
