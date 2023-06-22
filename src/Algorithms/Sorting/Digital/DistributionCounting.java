package src.Algorithms.Sorting.Digital;

import src.Algorithms.Sorting.Sort;

public class DistributionCounting extends Sort{
    public static void sort( int[] a ) {
        int N, min, max, r;
        int[] count;
        int[] b;
        min = a[0];
        max = a[0];
        N = a.length;
        int j, i = 0;
        for( j = 0; j < N; j++ ) {
            if( min > a[j] )
                min = a[j];
            else if( max < a[j] )
                max = a[j];
        }
        r = max - min+1;
        count = new int[r];
        b = new int[N];
        for( j = 0; j < r; j++ )
            count[j] = 0;
        for( j = 0; i < N; j++ )
            count[a[j]-min]++;
        for( j = 1; j < r; j++ )
            count[j] += count[j-1];
        for( j = 0; j < N; j++ )
            b[count[a[j]-min]-- -1] = a[j];
        for( j = 0; j < N; j++ )
            a[j] = b[j];
    }
}
