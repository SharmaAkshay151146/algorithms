import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private Node first; // top of the stack, most recently entered ode
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node ();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() { return current != null; }
        public void remove() { }

        public Item next() {
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        char[] c = "A B C D E F G H I J".toCharArray();

        for (char ch : c)
            s.push(ch);
        
        for (char ch : s)
            System.out.print(ch);
    }
}