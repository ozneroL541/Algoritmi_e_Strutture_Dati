package Algorithms.Sorting;

public abstract class Sort {
    /**
     * Method to organise an array of comparables
     * @param a array of comparables
     */
    public static void sort( Comparable[] a ) {}
    /**
     * Method to know if v is less than w
     * @param v first comparable
     * @param w second comparable
     * @return true if v is less than w
     */
    public static boolean less( Comparable v, Comparable w ) {
        return v.compareTo(w) < 0;
    }
    /**
     * Exchange a[i] with a[j]
     * @param a array
     * @param i position of the first element
     * @param j position of the second element
     */
    public static void exch( Comparable[] a, int i, int j ) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        // Other methods
    }
}
