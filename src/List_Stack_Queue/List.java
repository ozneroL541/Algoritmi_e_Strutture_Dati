package src.List_Stack_Queue;

/**
 * An object of the <code>List</code> class rapresents a list
 * of nodes with items <code>Item</code> in them.
 * 
 * @author Lorenzo Radice
 * @version 1.0
 */

public class List<Item> {
    // First node
    private Node first;
    // List lenght
    private int N;
    /** 
     * It checks if the list has no node.
     * @return true if there is no node
     * @return false if there is at least one node
    */
    public boolean isEmpty(){
        return first == null;
    }
    /**
     * It returns the list lenght
     * @return list lenght
     */
    public int length() {
        return N;
    }
    /**
     * It creates a node with the item and puts it at i position
     * @param item item
     * @param i position
    */
    public void Insert( Item item, int i ){
        // Counter
        int j = 1;
        // New node and precedent node
        Node new_node, pred;
        // First node is assigned to Precedent node
        pred = first;
        // To make a new node
        new_node = new Node();
        // Assign the parameter item to the new node
        new_node.item = item;
        // If the position parameter is the first one
        if ( i == 1 ){
            // Assign the new node created to the first one
            first = new_node;
            // Assign to the first node the precendent
            first.next = pred;
            // Increase the node numbers
            N++;
        } else {
            // While the position is not reached
            while ( j+1 < i ){
                // Increase the counter
                j++;
                // Go to the next node with pred
                pred = pred.next;
            }
            // Assign to the new node pointer the next node of the previous one
            new_node.next = pred.next;
            // Assign the new node to the previous node pointer
            pred.next = new_node;
            N++;
        }
    }
    /**
     * It deletes the node at position i
     * @param i position
     */
    public void Delete( int i ){
        // Counter
        int j = 1;
        // Previous node
        Node pred;
        // If the list is empty
        if ( isEmpty() )
            // Exit
            return;
        // Assign to previous the first node
        pred = first;
        // If the position to be deleted is the first one
        if ( i == 1 ){
            // Assign the to first node the second one
            first = first.next;
        } else {
            // While the right position isn't reached
            while ( j+1 < i ){
                // Increase the number
                j++;
                // Go to the next node with pred
                pred = pred.next;
            }
            // Assign to the next pointer the following node
            pred.next = (pred.next).next;
        }
        // Decrease the node lenght
        N--;
    }
    /**
     * It returns the item at position i
     * @param i position
     * @return item
     */
    public Item Read( int i ){
        // Counter
        int j = 1;
        // Preavious node
        Node pred;
        // If the list is empty
        if ( isEmpty() )
            // Return null
            return null;
        // First node assigned to the previous node
        pred = first;
        // While the node isn't reached
        while ( j < i){
            // Increase the counter
            j++;
            // Go to the next node with pred
            pred = pred.next;
        }
        // Returns the item found
        return (Item) pred.item;
    }        
}