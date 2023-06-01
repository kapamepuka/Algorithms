package hm_4;

public class TreePrinter {
    
    /**
     * Print a Tree in console
     * @param node - a node to print
     * @param sp - spacer
     */
    public static void print(Node node, String sp) {
        if (node != null) {
            System.out.println(sp + node.value + " " + node.color);
            print(node.leftChild, sp + "   ");
            print(node.rightChild, sp + "   ");
        }
    }
}