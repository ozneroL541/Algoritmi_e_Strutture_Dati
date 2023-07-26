package Data_Structures.Hash;

public class Hash {
    // Table dimension constant
    private final int DIMTAB = 81; // A random coprime of 256
    // Void constant
    private final Element VOID = null;
    // Deleted element constant
    private final Element DELETED = new Element("","");
    // Hash Table
    private Element[] Tab = new Element[DIMTAB];
    // Size
    private int size = 0;
    /**
     * Hash function
     * Hash function calculates the position
     * of the data in the table.
     * @param k data
     * @return position of the data
     */
    public int Hash(String k){
        // Hash calc
        int m = 0;
        // Code of the character
        int c;
        // For every letter of the string
        for( int h = 0; h < k.length(); h++ ){
            // Assign the code of the character of the current letter
            c = k.charAt(h);
            // Calculate the hash index
            m = ( 256 * m + c ) % DIMTAB;
        }
        // Return the hash index
        return m;
    }
    /**
     * Insert the element in the table
     * @param e element to insert
     */
    public void Insert(Element e) {
        // If there is still space in the table
        if ( size < DIMTAB ){
            // Calculate the index of the element
            int i = Hash(e.key);
            // While the cell is not void or deleted
            while( Tab[i] != VOID && Tab[i] != DELETED ){
                // Calculate the next hash index
                i = ( i + 1 ) % DIMTAB;
            }
            // Insert the element
            Tab[i] = e;
            // Increment the sixe of the elements in the table
            size++;
        } else
            // Output: There is no space available in the table
            System.out.println("HashTable is full");
    } 
    /**
     * Delete the element from the table
     * @param e element to delete
     */
    public void Delete(Element e) {
        // Calculate the index of the element
        int i = Hash(e.key);
        // Set j index as 0
        int j = 0;
        // While j is in the table and the element in i is neither void nor the element
        while( j <= DIMTAB && Tab[i] != VOID && Tab[i] != e ){
            // Go to the next hash index
            i = ( i + 1 ) % DIMTAB;
            // Increment j
            j++;
        }
        // If the element is the choosen one
        if ( Tab[i] == e ){
            // Assing the DELETED flag to the cell
            Tab[i] = DELETED;
            // Reduce the size of the elements in the table
            size--;
        } else
            // Outptu: the elemtn is not in the table
            System.out.println("There is not the element");
    }
    /**
     * Check if the element is in the table
     * @param e element
     * @return true if there is
     */
    public boolean Element(Element e) {
        // Calculate the index of the element
        int i = Hash(e.key);
        // Set the j index as 0
        int j = 0;
        // While j is in the table and the element in i is neither void nor the element
        while( j <= DIMTAB && Tab[i] != VOID && Tab[i] != e ){
            // Calculate the next index
            i = ( i + 1 ) % DIMTAB;
            // Increment j
            j++;
        }
        // If the element is in the table
        if( Tab[i] == e ){
            return true;
        } else {
            return false;
        }
    }
}
