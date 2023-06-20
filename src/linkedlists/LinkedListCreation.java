package linkedlists;

/**
 * @author amgarg
 */
public class LinkedListCreation {


    public static void deleteNodeLinkedListAtSpecificPosition(ListNode head, int position) {

        ListNode prev = null;
        int currentPos = 0;
        while (currentPos != position && head.next != null) {
            prev = head;
            head = head.next;
            currentPos++;
        }


        ListNode temp = head.next;
        prev.next = temp;
        head.next = null;

    }


    public static void printLinkedList(ListNode head) {


        ListNode temp = head;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }


    public static ListNode createLinkedList() {
        ListNode a = new ListNode(5);

        ListNode b = new ListNode(1);

        ListNode c = new ListNode(10);

        ListNode d = new ListNode(15);

        //linking nodes
        a.next = b;
        b.next = c;
        c.next = d;

        return a;
    }

    public static void main(String[] args) {
        ListNode a = createLinkedList();

        printLinkedList(a);


        deleteNodeLinkedListAtSpecificPosition(a, 1);

        printLinkedList(a);

    }
}
