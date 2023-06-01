package hm_3;

public class LinkList<T> {
   
    private Node<T> head;
    private Node<T> tail;

    /**
     * Find a node in List by value parameter
     * @param value - value to search a node in List
     * @return - a node contains value or null if node was not found 
     */
    public Node<T> find(T value) {
        Node<T> currentNode = head;
        while(currentNode != null) {
            if(value.equals(currentNode.getValue())) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
    
    /**
     * Add new node after last node of List
     * @param value - new value which will be added in List
     */
    public void addLast(T value) {
        Node<T> node = new Node<T>(value);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }

     /**
     * Add new node before head node of List
     * @param <T>
     * @param value - new value which will be added in List
     */
    public void addFirst(T value) {
        Node<T> node = new Node<T>(value);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
    }

    /**
     * Add new node at middle of List after current node 
     * @param value - new value which will be added in List
     * @param node - current node after that new value will be added in List
     */
    public void addAfter(T value, Node<T> node) {
        Node<T> next = node.getNext();
        Node<T> newNode = new Node<T>(value);
        node.setNext(newNode);
        newNode.setPrevious(node);
        if(next == null) {
            tail = newNode;
        } else {
            next.setPrevious(newNode);
            newNode.setNext(next);
        }
    }

    /**
     * Delete current node in List
     * @param node
     */
    public void delete(Node<T> node) {
        if(node != null) {
            Node<T> previous = node.getPrevious();
            Node<T> next = node.getNext();
            if(previous == null && next == null) {      // in case if a List has only one node 
                head = null;
                tail = null;
            } else if(previous == null) {               // in case if node to be deleted is head 
                next.setPrevious(null);
                head = next;
            } else if(next == null) {                   // in case if node to be deleted is tail 
                previous.setNext(null);
                tail = previous;
            } else {                                    // in other case
                previous.setNext(next);
                next.setPrevious(previous);
            }
        }
    }

    /**
     * Revert all nodes in a List
     */
    public void revert() {
        Node<T> currentNode = head;
        if(head != null && head.getNext() != null) {    // if a List contains minimum two elements
            while(currentNode != null) {
                Node<T> next = currentNode.getNext();
                Node<T> previous = currentNode.getPrevious();
                currentNode.setNext(previous);
                currentNode.setPrevious(next);
                if(previous == null) {                  // if current node is head 
                    tail = currentNode;
                }
                if(next == null) {                      // if current node is tail 
                    head = currentNode;
                }                                       // in other case
                currentNode = next; 
            }
        } 
    }

    /**
     * Print a List in console
     */
    public void print() {
        if(head != null) {
            Node<T> currentNode = head;
            Node<T> next = currentNode.getNext();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while(currentNode != null) {
                    sb.append(currentNode.getValue() + ", ");
                    //System.out.println(currentNode.value);
                    next = currentNode.getNext();
                    currentNode = next; 
            }
            sb.delete(sb.length() -2, sb.length());
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

}