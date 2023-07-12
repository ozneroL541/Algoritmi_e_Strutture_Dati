package Data_Structures.List_Stack_Queue;
/**
 * An object of the <code>Queue</code> class rapresents a queue of <code>Node</code>s.
 * 
 * @author Lorenzo Radice
 * @version 1.0
 */
public class Queue<Item>{
    // First Node
    private Node first;
    // Last Node
    private Node last;
    // Queue lenght
    private int N;
    /** 
     * It checks if the stack has no node.
     * @return true if there is no node
     * @return false if there is at least one node
    */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * It returns the stack lenght
     * @return stack size
     */
    public int size() {
        return N;
    }
    /**
     * It creates a node with the item and puts it at the end of the queue
     * @param item item
    */
    public void enqueue(Item item){
        // Initialize to the old last node the last node
        Node oldlast = last;
        // Create a new node and assings it to the last node
        last = new Node();
        // Item param is assigned to the last node item
        last.item = item;
        // Put the next node of the last node at null
        last.next = null;
        // If the queue i s empty
        if( isEmpty() )
            // Put the last node as first
            first = last;
        else
            // Last is assigned to the node next to the old last node
            oldlast.next = last;
        // Increase the queue lenght size
        N++;
    }
    /**
     * Remove the first item from the queue and returns it if it exist
     * @return the first item
     */
    public Item dequeue(){
        // If the queue is not empty
        if( !isEmpty() ){
            // Save the item of the first node in item
            Item item = (Item) first.item;
            // Put the second node as first
            first = first.next;
            // If the queue is empty
            if( isEmpty() )
                // Set the last node as null
                last = null;
            // Decrease the lenght of the queue
            N--;
            return item;
        } else
            return null;
    }
    /**
     * It returns the first item of the list
     * @return the first item
     */
    public Item front(){
        if( isEmpty() )
            return null;
        return (Item) first.item;
    }
    /**
     * It returns the lenght of the list
     * @return lenght
     */
    public int lenght() {
        return this.N;
    }
}
        