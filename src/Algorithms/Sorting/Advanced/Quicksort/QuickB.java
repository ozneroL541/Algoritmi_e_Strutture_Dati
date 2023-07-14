package Algorithms.Sorting.Advanced.Quicksort;

import Data_Structures.List_Stack_Queue.List;

public class QuickB extends Quick {
    /**
     * Partition on list for Bentley-Mcllroy Quicksort.
     * @param a list of Comparables
     * @return Three lists
     */
    public static List<Comparable>[] BPart( List<Comparable> a ){
        List<Comparable> c[] = new List[3];
        Comparable x, pivot;
        // Initialize the comparables to the first item of the list
        x = pivot = a.Read(1);
        // Add x to c[1]
        c[1].Add(x);
        // Delete the first item of a list
        a.Delete(1);
        // Read the following item of a list
        x = a.Read(1);
        // while x is not null
        while( x != null ){
            // If x is less than pivot
            if ( less( x, pivot ) )
                // Add x to c[0]
                c[0].Add(x);
            // If x is more than pivot
            else if ( less( pivot, x ) )
                // Add x to c[2]
                c[2].Add(x);
            // If x equals pivot
            else
                // Add x to c[1]
                c[1].Add(x);
            // Delete the first element of a
            a.Delete(1);
            // Set x as the following item of the list
            x = a.Read(1);
        }
        // Returns the array of lists
        return c;
    }
    /**
     * Bentley-Mcllroy Quicksort on list.
     * @param a list
     * @return the sorted list
     */
    public static List<Comparable> sort( List<Comparable> a ){
        // Support array of lists
        List<Comparable> c[];
        // If the list lenght is one or less it is already sorted
        if ( a.length() <= 1 )
            return a;
        // Partition on a
        c = BPart(a);
        // If the first list is not null
        if ( c[0] != null )
            // Recoursively Quicksort it
            c[0] = sort( c[0] );
        // If the third list is not null
        if ( c[2] != null )
            // Recoursively Quicksort it
            c[2] = sort( c[2] );
        // Connect all the lists together
        c[0].Connect( c[1] );
        c[0].Connect( c[2] );
        // Return the sorted list
        return c[0];
    }
}
