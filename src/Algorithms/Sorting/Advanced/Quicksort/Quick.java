package Algorithms.Sorting.Advanced.Quicksort;

import Algorithms.Sorting.Sort;
import Data_Structures.List_Stack_Queue.Stack;

public class Quick extends Sort {
    /**
     * Quicksort
     * 
     * Complexity
     * Worst
     * N. Comparisons:  Theta(n^2)
     * Best
     * N. Comparisons:  Theta(n*log(n))
     * Average
     * N. Comparisons:  Theta(2*ln(n))
     * @param a array of comparables
     */
    public static void sort( Comparable[] a ){
        // Execute the recoursive method
        quicksort( a, 0, a.length - 1 );
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
    private static void quicksort( Comparable[] a, int l, int r ) {
        // Stop if r is less than l
        if ( r <= l )
            return;
        // Partition the array
        int j = partition( a, l, r );
        // Quicksort the first part of the array
        quicksort( a, l, j-1 );
        // Quicksort the second part of the array
        quicksort( a, j+1, r );
    }
    /**
     * Iterative version of Quicksort
     * 
     * Complexity
     * Worst
     * N. Comparisons:  Theta(n^2)
     * Best
     * N. Comparisons:  Theta(n*log(n))
     * Average
     * N. Comparisons:  Theta(2*ln(n))
     * @param a array of comparables
     * @param a array of comparables
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
    /**
     * Divide the array in elements bigger and smaller than the pivot.
     * 
     * Complexity
     * N. Comparisons:  Theta(n)
     * @param a array
     * @param l pivot index
     * @param r last index of the array
     * @return pivot
     */
    public static int partition( Comparable[] a, int l, int r ) {
        // Set i as the beginning and j ad the end
        int i = l, j = r + 1;
        // Set the pivot
        Comparable v = a[l];
        // For ever 
        while ( true ){
            // Increase i
            // Go on while a[i] is less than pivot
            while ( less( a[++i], v ) )
                // Stop if i reaches the end
                if( i == r )
                    break;
            // Decrease j 
            // Go on while a[j] is more than pivot
            while ( less( v, a[--j] ) )
                // Stop if j reaches l
                if( j == l )
                    break;
            // Exit from while if i is more than j
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
}
