package src.Data_Structures.Graph;

public class AdjacencyMatrix {
    // Matrix
    private boolean [][] matrix = null;
    // Number of nodes
    private int nodes_number = 0;
    // Number of edges
    private int edges_number = 0;
    /**
     * This constructor copies the parameter in the privates fields
     * @param m matrix
     */
    public AdjacencyMatrix( boolean [][] m ){
        // Assign the matrix
        this.matrix = m;
        // Assign the number of nodes
        this.nodes_number = m.length;
        // Assign the number of edges
        this.edges_number = countEdges();
    }
    /**
     * This constructor create a matrix with n nodes
     * @param n nodes number
     */
    public AdjacencyMatrix( int n ){
        // Assign the number of nodes
        this.nodes_number = n;
        // Create the matrix
        this.matrix = new boolean[n][n];
    }
    /**
     * This method change the value of the edge beetween a and b
     * @param a first node
     * @param b second node
     * @param edge value of the edge
     */
    public void changeEdge( int a, int b, boolean edge ){
        if ( a < matrix.length && b < matrix.length ){
            matrix[a][b] = edge;
        }
    }
    private int countEdges(){
        int count = 0;
        for (boolean[] bs : this.matrix) {
            for (boolean b : bs) {
                if (b) {
                    count++;
                }
            }
        }
        return count;
    }
}
