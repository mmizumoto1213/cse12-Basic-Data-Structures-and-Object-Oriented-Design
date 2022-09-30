public class Node<E> {
    Node<E> next;
    E data;
    public Node(E elem) {
        this.data = elem;
        this.next = null;
    }

    public Node(E elem, Node<E> link) {
        this.data = elem;
        link.next = this.next;
        this.next = link;
    }

    public static void main(String[] args)
    {
        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(15, n1);
        Node<Integer> n3 = new Node<Integer>(2);
        n2.next = n3.next;
        // CHECKPOINT   
        System.out.println(n1.next); 
        System.out.println(n2.next); 
        System.out.println(n3.next); 
        System.out.println(n1.next); 
    }
}