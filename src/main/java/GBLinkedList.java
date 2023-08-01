import java.util.Iterator;

public class GBLinkedList<E> implements GBList<E> {
    private transient int size = 0;
    private transient Node<E> first;
    private transient Node<E> last;

    public GBLinkedList() {
        this.first = null;
        this.last = null;
    }


    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }


    public void addFirst(E e) {
        linkFirst(e);
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        linkBefore(e, node(index));
    }


    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException();
        }
    }
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void linkLast(E e) {
        Node<E> lst = last;
        Node<E> newNode = new Node<>(lst, e, null);
        last = newNode;
        if (lst == null)
            first = newNode;
        else
            lst.next = newNode;
        size++;
    }

    private void linkFirst(E e) {
        Node<E> fst = first;
        Node<E> newNode = new Node<>(null, e, fst);
        first = newNode;
        if (fst == null)
            last = newNode;
        else
            fst.prev = newNode;
        size++;
    }

    private void linkBefore(E e, Node<E> node) {
        Node<E> pr = node.prev;
        Node<E> newNode = new Node<>(pr, e, node);
        node.prev = newNode;
        if (pr == null)
            first = newNode;
        else
            pr.next = newNode;
        size++;
    }
    private void unlink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.next = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.prev = null;
        }
        node.item = null;
        size--;
    }

    private Node<E> node(int index) {
        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public void remove(int index) {
        checkPositionIndex(index);
        unlink(node(index));
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(int index, E e) {
        checkElementIndex(index);
        node(index).item = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return node(index++).item;
            }
        };
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(node(i).item).append(" ");
        }
        return sb.toString();
    }
}

