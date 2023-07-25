package Algorithms.Sorting.Digital;

import Algorithms.Sorting.Sort;
import Data_Structures.List_Stack_Queue.List;
import Data_Structures.List_Stack_Queue.Queue;
import Algorithms.Sorting.Elementary.Bubble;

public class Bucket extends Sort {
    // Cardinality of the alphabet
    private static int NSIMB = 0;
    // Alphabet
    private static Character [] alphabet;
    /**
     * Distribution Counting
     * All the strings of the queue must have the same number of letters and must belong to the same alphabet.
     * It is stable.
     * It is not adaptive.
     * k = lenght of words
     * m = cardinality of the alphabet
     * n = number of words
     * 
     * Complexity
     * N. Operations:  Theta( k*(n+m) )
     * @param l queue of strings
     */
    public static void sort( Queue<String> l ) {
        // Initialize the alphabet
        Alphabet(l);
        // String w
        String w;
        // Array of Strings
        Queue<String>[] s = new Queue[NSIMB];
        // Lenght of the word
        int LENGTHWORD = ( (String) l.front()).length();
        // Initilize e to 0
        int e = 0;
        // For every letter of the words from the back
        for( int j = LENGTHWORD; j > 0; j-- ){
            // While the queue is not empty
            while(!l.isEmpty()){
                // Dequeue l
                w = l.dequeue();
                // Set e to the digit 
                e = Digit(w,j);
                // Enqueue w in the right letter queue
                s[e].enqueue(w);
            }
            // For every letter of the alphabet except the first
            for( int i = 1; i < NSIMB; i++ ){
                // Chain all the Queue
                s[0].chain(s[i]);
                s[i]=null;
            }
            // Copy the queue in l
            l = s[0];
            // Reset s[0]
            s[0] = null;
        }
    }
    /**
     * Converts the character <code>w.charAt(j)</code> in the position the alphabet.
     * 0 if is first
     * @param w String
     * @param j char index
     * @return position in the alphabet
     */
    private static int Digit(String w, int j) {
        // Return statment
        int r = -1;
        // Flag
        boolean f = true;
        // While reach the letter
        for ( int i = 0; i < NSIMB && r < 0; i++) {
            // If reach the letter
            if ( alphabet[i].equals(w.charAt(j)) ) {
                // Return the index
                r = i;
            }
        }
        return r;
    }
    /**
     * This method returns the number of letters
     * contained in each word of the l queue.
     * @param l queue of words
     * @return number of letters of the alphabet
     */
    private static void Alphabet( Queue<String> l ){
        // Numeber of the letter of the alphabet
        int n = 0;
        // Copy of the list
        Queue<String> co = l;
        // Alphabet counter
        List<Character> a = new List<Character>();
        // Support String
        String s;
        // Support Char
        Character ch;
        // For every String in the copy
        while (!co.isEmpty()) {
            // Copy the current String in the support String
            s = co.dequeue();
            // For every character in the string
            for (int i = 0; i < s.length(); i++) {
                // Copy the character in the support array
                ch = s.charAt(i);
                // If it is not in the alphabet list
                if ( ! a.Contains(ch)) {
                    // Add it to the list
                    a.Add(ch);
                    // Increment the return
                    n++;
                }
            }
        }
        // Create an array for the alphabet
        alphabet = new Character[n];
        // Copy the list in the array
        for (int i = 0; i < n; i++) {
            alphabet[i] = a.Read(i);
        }
        // Order the array
        Bubble.adaptive_sort(alphabet);
        // Assign the number of letters of the alphabet
        NSIMB = n;
    }
}
