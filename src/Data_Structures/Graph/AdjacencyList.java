package src.Data_Structures.Graph;

import java.util.ArrayList;

public class AdjacencyList extends Graph {
    // Number of nodes
    private int nodes_number = 0;
    // Number of edges
    private int edges_number = 0;
    // List of adjacency
    private ArrayList<Integer> [] aList = null;
    /**
     * This constructor create a list with n nodes
     * @param n nodes number
     */
    public AdjacencyList( int n ) {
        this.aList = new ArrayList[n];
        this.nodes_number = n;
    }
    /**
     *  This method adds an oriented edge from the start node to node the end node
     * @param from start node
     * @param to end node
     */
    public void addEdge( int from, int to ) {
        if ( from > 0 && from <= this.nodes_number && to > 0 && to <= this.nodes_number ) {
            int f = from - 1;
            int t = to - 1;
            if ( ! this.aList[f].contains(t) ) {
                this.aList[f].add(t);
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
}
