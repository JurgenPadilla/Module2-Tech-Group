package data_structures;

public class DoblyLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

//    public DoblyLinkedList() {
//        size = 0;
//    }
//
//    public void addFirst(T element) {
//        Node tmp = new Node(element, head, null);
//        if (head != null) {
//            head.prev = tmp;
//        }
//        head = tmp;
//        if (tail == null) {
//            tail = tmp;
//        }
//        size++;
//        System.out.println("adding: " + element);
//    }
//
//    /**
//     * adds element at the end of the linked list
//     *
//     * @param element
//     */
//    public void addLast(E element) {
//
//        Node tmp = new Node(element, null, tail);
//        if (tail != null) {
//            tail.next = tmp;
//        }
//        tail = tmp;
//        if (head == null) {
//            head = tmp;
//        }
//        size++;
//        System.out.println("adding: " + element);
//    }
//
//    /**
//     * this method walks forward through the linked list
//     */
//    public void iterateForward() {
//
//        System.out.println("iterating forward..");
//        Node tmp = head;
//        while (tmp != null) {
//            System.out.println(tmp.element);
//            tmp = tmp.next;
//        }
//    }
//
//    /**
//     * this method walks backward through the linked list
//     */
//    public void iterateBackward() {
//
//        System.out.println("iterating backword..");
//        Node tmp = tail;
//        while (tmp != null) {
//            System.out.println(tmp.element);
//            tmp = tmp.prev;
//        }
//    }
//
//    /**
//     * this method removes element from the start of the linked list
//     *
//     * @return
//     */
//    public E removeFirst() {
//        if (size == 0) throw new NoSuchElementException();
//        Node tmp = head;
//        head = head.next;
//        head.prev = null;
//        size--;
//        System.out.println("deleted: " + tmp.element);
//        return tmp.element;
//    }
//
//    /**
//     * this method removes element from the end of the linked list
//     *
//     * @return
//     */
//    public E removeLast() {
//        if (size == 0) throw new NoSuchElementException();
//        Node tmp = tail;
//        tail = tail.prev;
//        tail.next = null;
//        size--;
//        System.out.println("deleted: " + tmp.element);
//        return tmp.element;
//    }

}
