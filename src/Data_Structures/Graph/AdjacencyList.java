package src.Data_Structures.Graph;

import java.util.ArrayList;

import src.Data_Structures.List_Stack_Queue.List;
import src.Data_Structures.List_Stack_Queue.Node;
import src.Data_Structures.List_Stack_Queue.Queue;

public class AdjacencyList<Item> extends Graph {
    // Number of nodes
    private int nodes_number = 0;
    // Number of edges
    private int edges_number = 0;
    // List of adjacency
    private List<Node> [] aList = null;
    // Nodes
    private Node [] nodes;
    /**
     * This constructor create a list with n nodes
     * @param n nodes number
     */
    public AdjacencyList( Node [] n ) {
        this.nodes_number = n.length;
        this.aList = new List[this.nodes_number];
        this.nodes = n;
        this.edges_number = 0;
    }
    /**
     *  This method adds an oriented edge from the start node to node the end node
     * @param from start node
     * @param to end node
     */
    public void addEdge( Item from, Item to ) {
        int [] c = new int[2];
        c[0] = -1;
        c[1] = -1;

        for (int i = 0; (c[0] == -1 || c[1] == -1) && i < this.nodes.length; i++) {
            if ( c[0] == -1 && ( this.nodes[i].equals(from) ) )
                c[0] = i;
            if ( c[1] == -1 && ( this.nodes[i].equals(to) ) )
                c[0] = i;
        }
        if ( c[0]*c[1] < 0 ) {
            if ( ! this.aList[c[0]].contains(to) ) {
                this.aList[c[0]].add(to);
                this.edges_number++;
            }
        }
    }
    /**
     *  This method removes an oriented edge from the start node to node the end node
     * @param from start node
     * @param to end node
     */
    public void removeEdge( int from, int to ) {
        if ( from > 0 && from <= this.nodes_number && to > 0 && to <= this.nodes_number ) {
            int f = from - 1;
            int t = to - 1;
            if ( ! this.aList[f].contains(t) ) {
                this.aList[f].remove(t);
                this.edges_number--;
            }
        }
    }
    @Override
    public String toString() {
        String out = "";
        for ( int i = 0; i < aList.length; i++ ) {
            out += (i + 1) + ":";
            for ( int a : aList[i]) {
                out += "\t" + ( a + 1 );
            }
            if ( i < aList.length - 1 )
                out += "\n";
        }
        return out;
    }
    
    public void Breadthfirst( int node_s){
        Queue<Node> q = new Queue<Node>();
        List<Lato> u = new List<Lato>();
        q.enqueue(s);
        vecchio[s]=1;
        for (v in V)
            if ( v != s )
                vecchio[v] = 0;
        while (!q.isEmpty()) {
            v = q.front();
            q.dequeue();
            v.visita();
            for (w in Lista di adiacenza di v)
                if (vecchio[w]){
                    vecchio[w] = 0;
                    q.enqueue(w);
                    u.Insert({v,w},1);
                }
        }
    }
}
