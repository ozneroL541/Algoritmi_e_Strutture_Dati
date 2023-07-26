package Data_Structures.Hash;

public class Hash {
    // Table dimension constant
    private final int DIMTAB = 81; // A random coprime of 256
    // Void constant
    private final Element VOID = null;
    // Deleted element constant
    private final Element DELETED = new Element("","");
    // Table
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
        int m = 0; int c;
        for( int h = 0; h < k.length(); h++ ){
            c = k.charAt(h);
            m = ( 256 * m + c ) % DIMTAB;
        } 
        return m;
    }
    /**
     * Insert the element in the table
     * @param e element to insert
     */
    public void Insert(Element e) {
        if ( size < DIMTAB ){
            int i = Hash(e.key);
            while( Tab[i] != VOID && Tab[i] != DELETED ){
                i = ( i + 1 ) % DIMTAB;
            }
                Tab[i] = e;
                size++; 
        } else
            System.out.println("HashTable is full");
    } 
    /**
     * Delete the element from the table
     * @param e element to delete
     */
    public void Delete(Element e) {
        int i = Hash(e.key);
        int j = 0;
        while( j <= DIMTAB && Tab[i] != VOID && Tab[i] != e ){
            i = (i+1)%DIMTAB;
            j++;
        }
        if ( Tab[i] == e ){
            Tab[i] = DELETED;
            size--;
        } else
            System.out.println("There is not the element");
    }
    public boolean Element(Element e) {
        int i = Hash(e.key);
        int j = 0;
        while( j <= DIMTAB && Tab[i] != VOID && Tab[i] != e ){
            i = (i+1) % DIMTAB;
            j++;
        }
        if( Tab[i] == e ){
            return true;
        } else {
            return false;
        }
    }
}
