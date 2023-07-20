package Algorithms.Sorting.Elementary;

import java.net.Socket;

import Algorithms.Sorting.Sort;

public class Bubble extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        // For every element of the array
        for ( int i = 0; i < N; i++ )
            // Starting from the back of the array
            // going back
            for ( int j = N - 1; j > i; j-- )
                // If a[j] is minor than the
                // previous one
                if ( less( a[j], a[j-1] ) )
                    // Eschange them
                    exch(a, j, j-1);
    }
    public static void adaptive_sort(Comparable[] a) {
        // If any exchange occours
        boolean ex = true;
        int N = a.length;
        // For every element of the array
        // Stop if there is a cycle without changes
        for( int i = 0; ! ex && i < N; i++ ) {
            // Set exchange as false
            ex = false;
            // Starting from the back of the array
            // going back
            for( int j = N - 1; j > i; j-- )
                // If a[j] is minor than the
                // previous one
                if ( less( a[j], a[j-1] ) ) {
                    // Exchange them
                    exch( a, j, j-1 );
                    // Set the exchange flag as true
                    ex = true;
                }
        }
    }
}
