package Algorithms.Examples;

public class Min {
    /**
     * It calculates the minor in an array a
     * @param a array
     * @param lo lower bound of the array
     * @param hi higher boung of the array
     */
    public static int min ( int [] a, int lo, int hi ) {
        // If low equals high
        if ( lo == hi )
            // Return it
            return a[lo];
        // Calculate the middle of the array
        int mid = ( lo + hi ) / 2;
        // Calculate the minor of the first half of the array
        int min1 = min( a, lo, mid );
        // Calculate the minor of the second half of the sarray
        int min2 = min( a, mid+1, hi );
        // If the first minor is lower
        if ( min1 < min2 )
            // Return the minor
            return min1;
        else
            // Return the minor
            return min2;
    }
}
