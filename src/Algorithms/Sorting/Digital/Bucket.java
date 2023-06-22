package src.Algorithms.Sorting.Digital;

import src.Algorithms.Sorting.Sort;
import src.Data_Structures.List_Stack_Queue.Queue;

public class Bucket extends Sort {
    public static void bucketsort( Queue<String> l) {
        String w;
        Queue<String>[] s;
        int NSIMB = l.lenght();
        //s = new Queue<String>[NSIMB];
        int LENGTHWORD = l.front().length();
        for( int j = LENGTHWORD; j > 0; j-- ) {
            while(!l.isEmpty()) {
                w = l.front();
                l.delete(1);
                e = Digit(w,j);
                s[e].enqueue(w);
            }
            for(int i=1; i<NSIMB; i++) {
                s[0].chain(s[i]);
                s[i]=null;
            }
            l=s[0];
            s[0]=null;
        }
    }
}
