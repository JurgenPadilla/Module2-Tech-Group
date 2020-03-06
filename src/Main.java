import data_structures.MyLinkedList;
import data_structures.Node;
//import data_structures.Value;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        Node<String> node1 = new Node<>("a");
        Node<String> node2 = new Node<>("b");
        Node<String> node3 = new Node<>("c");
        Node<String> node4 = new Node<>("d");
        System.out.println(node1.getValue());
        System.out.println(node2.getValue());
        System.out.println(node3.getValue());
        System.out.println(node4.getValue());

        MyLinkedList<String> list = new MyLinkedList<>();
        list.insert(list, "a");
        list.insert(list, "b");
        list.insert(list, "c");
        list.printList(list);
        list.deleteByKey(list, "a");
        list.printList(list);

    }
}
