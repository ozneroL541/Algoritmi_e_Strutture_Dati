package src.Algorithms.Sorting.Digital;

import src.Algorithms.Sorting.Sort;
import src.Data_Structures.List_Stack_Queue.Queue;

public class Bucket extends Sort {
    // TODO
    public static void bucketsort( Queue<String> l) {
        String w;
        int NSIMB = l.lenght() - 1;
        Queue<String>[] s = new Queue[NSIMB];
        int LENGTHWORD = ( (String) l.front()).length();
        int e = 0;
        for( int j = LENGTHWORD; j > 0; j-- ) {
            while(!l.isEmpty()) {
                w = l.dequeue();
                e = Digit(w,j);
                s[e].enqueue(w);
            }
            for( int i = 1; i < NSIMB; i++ ) {
                s[0].chain(s[i]);
                s[i]=null;
            }
            l=s[0];
            s[0]=null;
        }
    }
    /**
     * Converts the character <code>w.charAt(j)</code> in the position
     * @param w String
     * @param j char index
     * @return position of w.charAt(i)
     */
    private static int Digit(String w, int j) {
        return 0;
    }
}
