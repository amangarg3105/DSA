package linkedlists;

/**
 * @author amgarg
 */
public class ReverseTheLinkedList {

    public static void reverse(ListNode head) {

        ListNode currentHead = head;
        ListNode restOfLLHead = null;
        ListNode prevHead = null;

        while(currentHead != null) {
            restOfLLHead = currentHead.next;
            currentHead.next = prevHead;
            prevHead = currentHead;
            currentHead = restOfLLHead;
        }

        head = prevHead;

        LinkedListCreation.printLinkedList(head);
    }



    public static ListNode reverseRecursive(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;
        return  newHead;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListCreation.createLinkedList();
        ListNode newHead = reverseRecursive(head);
        LinkedListCreation.printLinkedList(newHead);


    }
}
