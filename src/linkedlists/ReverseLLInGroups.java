package linkedlists;

/**
 * @author amgarg
 */
public class ReverseLLInGroups {

    public ListNode reverseKGroup(ListNode head, int k) {



       ListNode node = head;

       int count = 0;
       while(count < k) {
           if (node == null) {
               return head;
           }

           node = node.next;
           count++;
       }

       ListNode reverseHead = reverseKGroup(node, k);

       while(count > 0) {
           ListNode next = head.next;
           head.next = reverseHead;
           reverseHead = head;
           head = next;
           count--;
       }
       return reverseHead;
    }
}
