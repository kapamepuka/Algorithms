package hm_4;

public class Program {

    public static void main(String[] args) {
        
        RedBlackTree tree = new RedBlackTree();
        tree.add(24);
        tree.add(5);
        TreePrinter.print(tree.getRoot(), "");
        
        // Пытаемся добавить в дерево повторяющееся значение и используем обратную связь метода Add о том, добавлено значение или нет
        if(tree.add(5)) { 
            TreePrinter.print(tree.getRoot(), "");
        } else {
            System.out.println("Error: this value already exists in tree");
        }                      

        tree.add(1);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");
        
        tree.add(15);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");
        
        tree.add(3);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");
        
        tree.add(8);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");

        tree.add(13);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");

        tree.add(16);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");
    }
}