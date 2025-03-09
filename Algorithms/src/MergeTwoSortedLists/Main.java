package MergeTwoSortedLists;
import Model.Node;

public class Main {
    public static void main(String[] args) {

        Node l1 = new Node(1);
        l1.setNext(new Node(3));
        l1.getNext().setNext(new Node(5));

        Node l2 = new Node(2);
        l2.setNext(new Node(4));
        l2.getNext().setNext(new Node(6));

        Node mergedHead = mergeTwoLists(l1, l2);

        while (mergedHead != null) {
            System.out.print(mergedHead.getVal() + " -> ");
            mergedHead = mergedHead.getNext();
        }
        System.out.print("null");
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        // Create a dummy node to simplify the merging process.
        Node dummy = new Node(-1); // this is a dummy node value; when returning this we'll return dummy.getNext()
        Node current = dummy;

        // Loop through both lists until we reach the end of one.
        while (l1 != null && l2 != null) {
            if (l1.getVal() < l2.getVal()) { //compare the values so it will be sorted.
                current.setNext(l1);
                l1 = l1.getNext(); //shrink them down to next ListNode
            } else {
                current.setNext(l2);
                l2 = l2.getNext(); //shrink them down to next ListNode
            }
            current = current.getNext(); //iterate to the next node
        }

        // Attach any remaining elements.
        if (l1 != null) {
            current.setNext(l1);
        } else {
            current.setNext(l2);
        }

        // Return the next of dummy node which is the head of the merged list.
        return dummy.getNext();
    }
}
