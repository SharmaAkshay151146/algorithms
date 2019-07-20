import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first; // link to the most recently added node
    private Node last; // link to the least recently added node
    private int N; // number of items in the queue

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void enqueue(Item item) {
        // Add item to the end of the list
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<Character> q = new Queue<>();
        char[] c = "Belen San Martin Diez".toCharArray();

        for (Character ch : c) q.enqueue(ch);

        for (Character ch : q) System.out.print(ch);
    }
    

}