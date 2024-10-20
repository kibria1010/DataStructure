package bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Md Golam Kibria
 */
public class Bag<T> implements Iterable<T> {

    Node<T> first;
    int n;
    
    public static class Node<T> {
        T data;
        Node<T> next;
    }

    public Bag() {
        first = null;
        n=0;
    }
    
    public void add(T data) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.data = data;
        first.next = oldFirst;
        n++;
    }
    
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }
    
    public static void main(String[] args) {
        Bag<String> list = new Bag();
        list.add("A");
        list.add("B");
        list.add("C");
        
        for (String data : list) {
            System.out.println(data + " ");
        }
        
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String data = it.next();
            System.out.print(data + " ");
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedIterator(first);
    }
    
    private class LinkedIterator implements Iterator<T> {
        
        Node<T> current;

        public LinkedIterator(Node<T> current) {
            this.current = current;
        }
        

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
        
    }

}
