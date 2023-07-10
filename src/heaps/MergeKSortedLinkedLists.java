package heaps;


import java.util.PriorityQueue;

/**
 * @author amgarg
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLinkedLists {



    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;

        if (lists == null || n == 0) {
            return null;
        }

        PriorityQueue<ListNode> minheap = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);

       for (int index = 0; index < lists.length; index++) {
           ListNode headNode = lists[index];
           if (headNode != null)  {
               minheap.add(headNode); //
           }
       }

       ListNode dummyNode = new ListNode(-1);
       ListNode dummyHead = dummyNode;

       while (!minheap.isEmpty())  {
           ListNode currentNode =  minheap.remove(); //O(log n)

           dummyNode.next = currentNode;
           dummyNode = dummyNode.next;
           if (currentNode.next != null) {
               minheap.add(currentNode.next); // O (log n)
           }
       }

       return dummyHead.next;
    }
}
