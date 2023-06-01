package hm_4;

public class Node {
    
    int value;
    Node leftChild;
    Node rightChild;
    Color color;

    /**
     * Create a new node
     * Commonly all new nodes are RED
     * @param value - integer unique key of node
     */
    public Node(int value) {
        this.value = value;
        this.color = Color.RED;
    }

}