package linkedlists;

/**
 * @author amgarg
 */


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyLL {

    /**
     * T.C - O(n)
     * S.C - O(n)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {



        if(head == null) {
            return head;
        }
        //Creating the clones of original nodes and attach them in original list
        Node original = head;

        while (original != null && original.next != null) {
            Node cloneNode = new Node(original.val);
            Node next = original.next;
            original.next = cloneNode;
            cloneNode.next = next;
            original = original.next.next;
        }

        original.next = new Node(original.val);


        original = head;
        /*
         * Adjusting the random pointers of cloned Nodes
         */
        while (original != null && original.next != null) {
            if(original.random != null) {
                original.next.random = original.random.next;
            }
           original = original.next.next;
        }


        /*
         * Seperation of duplicate nodes from original list
         */
        original = head;
        Node cloned = head.next;
        Node clonedHead = head.next;

        while (original.next !=  null && cloned.next != null) {
            original.next = original.next.next;
            cloned.next = cloned.next.next;
            original = original.next;
            cloned = cloned.next;
        }

        original.next = null;

        return clonedHead;
    }
}
