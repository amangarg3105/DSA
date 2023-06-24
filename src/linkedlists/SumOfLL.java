package linkedlists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amgarg
 */
public class SumOfLL {


    /**
     * T.C - O(n1 + n2) where is n1 is number of nodes in l1 and n2 is number of nodes in l2
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result;

        if(length(l1) > length(l2)) {
            int diff = length(l1) - length(l2);
            result = helper(l1, l2, diff);
        } else {
            int diff = length(l2) - length(l1);
            result = helper(l2, l1, diff);
        }


        ListNode temp = new ListNode(1);
        if(result.val > 9) {
            result.val = result.val % 10;
            temp.next = result;
            result = temp;
        }

        return result;
    }

    private int length(ListNode head) {
        int length = 0;
        ListNode currentNode = head;

        while(currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    private ListNode helper(ListNode l1, ListNode l2, int diff) {

        if(l1 == null) {
            return null;
        }

        ListNode currentSum;
        if(diff == 0) {
             currentSum = new ListNode(l1.val + l2.val);
        } else {
            currentSum = new ListNode(l1.val);
        }


        ListNode recursiveSum;

        if(diff == 0) {
            recursiveSum = helper(l1.next, l2.next, diff);
        } else {
            recursiveSum = helper(l1.next, l2, diff - 1);
        }

        if(recursiveSum != null && recursiveSum.val > 9) {
            recursiveSum.val = recursiveSum.val % 10;
            currentSum.val  = currentSum.val + 1;
        }

        currentSum.next = recursiveSum;

        return currentSum;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println(list.get(0));
    }
}
