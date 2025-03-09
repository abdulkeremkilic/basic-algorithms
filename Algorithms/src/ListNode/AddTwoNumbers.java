package ListNode;

import Model.Node;

public class AddTwoNumbers {
    public static void main(String[] args) {

        // [2,4,3]
        Node l1 = new Node(2);
        Node l2 = new Node(4);
        Node l3 = new Node(3);

        l2.setNext(l3);
        l1.setNext(l2);


        // [5,6,4]
        Node l4 = new Node(5);
        Node l5 = new Node(6);
        Node l6 = new Node(4);

        l5.setNext(l6);
        l4.setNext(l5);


        // Should be : [7,0,8]
        listNodePrinter(addTwoNumbers(l4, l1));

    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node head = new Node(0);
        Node curr = head;
        int carry = 0;
        // if there is a carry number or l1 is not null; means there is still numbers ahead of the node or l2 is not null; proceed
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                carry += l1.getVal();
                l1 = l1.getNext(); // Shifting the ListNode to next ListNode.
            }

            if (l2 != null) {
                carry += l2.getVal();
                l2 = l2.getNext(); // Shifting the ListNode to next ListNode.
            }

            curr.setNext(new Node(carry % 10)); //set reminder as the next ListNode's val.
            // Note: suggest you have 12 as carry sum. You have to get the 2 out of it to pass it as a next.val.
            // [2,4,3]
            // [5,6,4]
            // 2 + 5 = 7 -> goes directly as nextVal.
            // 4 + 6 = 10 -> 0 goes as nextVal. 1 goes to carry.
            // 4 + 3 + 1(carry) = 8 -> goes as nextVal.
            carry /= 10; // get the carry number; so we can pass it to next iteration.
            curr = curr.getNext();
        }
        return head.getNext();
    }

    public static void listNodePrinter(Node listNode) {
        System.out.print("[");
        while (listNode != null) {
            System.out.print(listNode.getVal());
            if (listNode.getNext() != null)
                System.out.print(",");
            listNode = listNode.getNext();
        }
        System.out.println("]");
    }
}
