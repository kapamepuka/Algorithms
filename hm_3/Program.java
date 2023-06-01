package hm_3;

public class Program {
    
    public static void main(String[] args) {
        // Создаем лист (двусвязный список) целочисленных значений
        LinkList<Integer> list1 = new LinkList<>();
        // Добавляем в лист новые ноды и значения различными способами
        list1.addLast(5);
        list1.addLast(447);
        list1.addLast(6);
        list1.addFirst(1);
        list1.addFirst(4);
        list1.addAfter(445, list1.find(447));
        list1.print();
        
        // Разворачиваем лист
        list1.revert();
        System.out.println("Reverted list:");
        list1.print();
        
        // Удаляем из листа ноду по ее значению
        int del = 447;
        System.out.println("List after element with value = " + del + " was deleted:");
        list1.delete(list1.find(del));
        list1.print();

        // Создаем лист из элементов строкового типа
        LinkList<String> list2 = new LinkList<>();
        list2.addLast("b");
        list2.addLast("c");
        list2.addFirst("a");
        list2.print();
        list2.revert();
        list2.print();
        String strdel = "b";
        System.out.println("List after element with value = " + strdel + " was deleted:");
        list2.delete(list2.find(strdel));
        list2.print();
    }
}