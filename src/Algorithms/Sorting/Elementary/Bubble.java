package src.Algorithms.Sorting.Elementary;

import java.net.Socket;

import src.Algorithms.Sorting.Sort;

public class Bubble extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for ( int i = 0; i < N; i++ )
            for ( int j = N - 1; j > i; j-- )
                if ( less( a[j], a[j-1] ) )
                    exch(a,j,j-1);
    }
    public static void adaptive_sort(Comparable[] a) {
        boolean scambio; int N=a.length;
        for( int i = 0; i < N; i++ ) {
            scambio = false;
            for( int j = N - 1; j > i; j-- )
                if ( less( a[j], a[j-1] ) ) {
                    exch( a, j, j-1 );
                    scambio = true;
                }
            if ( !scambio )
                break;
        }
    }
}
