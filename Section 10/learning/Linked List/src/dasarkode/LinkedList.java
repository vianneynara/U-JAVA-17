package dasarkode;

class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int newData)
        {
            data = newData;
            next = null;
        }
    }
}