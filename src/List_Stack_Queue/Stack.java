package src.List_Stack_Queue;
/**
 * An object of the <code>Stack</code> class rapresents a stack of <code>Node</code>s.
 * 
 * @author Lorenzo Radice
 * @version 1.0
 */
public class Stack<Item> {
    // First Node
    private Node first;
    // Stack Size
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
     * It creates a node with the item and puts it at the top of the stack
     * @param item item
    */
    public void push(Item item){
        // Initialize the old first with first
        Node oldfirst = first;
        // Assign to the first node a new node
        first = new Node();
        // Assign to the first node the item in parameter
        first.item = item;
        // Assign to the first next the old node
        first.next = oldfirst;
        // Increase the stack size
        N++;
    }
    /**
     * Remove the first item from the stack and returns it
     * @return the first item
     */
    public Item pop(){
        // If the stack is empty
        if ( isEmpty() )
            // Exit
            return null;
        // Initialize item to the first item of the stack
        Item item = (Item) first.item;
        // Put the second node as the first one
        first = first.next;
        // Decrease the stack size
        N--;
        return item;
    }
    /**
     * It returns the first item of the stack
     * @return the first item
     */
    public Item top(){
        if ( isEmpty() )
            return null;
        return (Item) first.item;
    }
}
