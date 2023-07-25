package Algorithms.Sorting.Digital;

import Algorithms.Sorting.Sort;

public class DistributionCounting extends Sort{
    /**
     * Distribution Counting
     * All the elements of the array mus be integers.
     * N = number of elements
     * r = number of repetitions
     * 
     * Complexity
     * N. Operations:  Theta( N + r )
     * @param a array of integers
     */
    public static void sort( int[] a ) {
        int N, min, max, r;
        int[] count, b;
        // Set the first element as min
        min = a[0];
        // Set the first element as max
        max = a[0];
        // Set lenght
        N = a.length;
        // Indexes
        int j, i = 0;
        // Search min, max and r with the following for
        // For every element
        for( j = 0; j < N; j++ ) {
            // If a[j] is minor than min
            if( min > a[j] )
                // Set a[j] as min
                min = a[j];
            // If a[j] is greater than max
            else if( max < a[j] )
                // Set a[j] as max
                max = a[j];
        }
        // Set the range as the difference between max and min
        r = max - min + 1;
        // Create an array of int with lenght r
        count = new int[r];
        // Create another array to store the numbers
        b = new int[N];
        // Set all the elements of count to 0
        for( j = 0; j < r; j++ )
            count[j] = 0;
        // For every element of the array a
        for( j = 0; i < N; j++ )
            // Increase the equivalent element of count
            count[ a[j] - min ]++;
        // For every element of count, starting with the second one
        for( j = 1; j < r; j++ )
            // Add the previous element to the current one
            count[j] += count[j-1];
        // For every element of the array a
        for( j = 0; j < N; j++ )
            // Assign the current element of a to the position in b described by the int in count equivalent to the current element of a
            // Decrease the current int of count
            // Next time there is that element, the position will be the previous one
            b[ count[a[j]-min]-- -1 ] = a[j];
        // Copy the element of b in a
        for( j = 0; j < N; j++ )
            a[j] = b[j];
    }
}
