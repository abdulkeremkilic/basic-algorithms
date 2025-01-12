package MergeTwoSortedLists;
import Model.ListNode;

public class Main {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.setNext(new ListNode(3));
        l1.getNext().setNext(new ListNode(5));

        ListNode l2 = new ListNode(2);
        l2.setNext(new ListNode(4));
        l2.getNext().setNext(new ListNode(6));

        ListNode mergedHead = mergeTwoLists(l1, l2);

        while (mergedHead != null) {
            System.out.print(mergedHead.getVal() + " -> ");
            mergedHead = mergedHead.getNext();
        }
        System.out.print("null");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the merging process.
        ListNode dummy = new ListNode(-1); // this is a dummy node value; when returning this we'll return dummy.getNext()
        ListNode current = dummy;

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
