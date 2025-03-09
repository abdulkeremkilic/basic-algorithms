package Model;

public class Node {
    private int val;
    private Node next;

    public Node(int x) {
        val = x;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return this.val;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
