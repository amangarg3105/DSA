package trees;

/**
 * @author amgarg
 */


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class NextRightPointer {

    public Node connect(Node root) {

        Node mainRoot = root;

        //vertical level loop
        while(root != null) {

            Node tempNode = new Node(Integer.MAX_VALUE);
            Node currentNode = tempNode;

            //horizontal level loop
            while (root != null) {
                if(root.left != null) {
                    currentNode.next = root.left;
                    currentNode = currentNode.next;
                }

                if(root.right != null) {
                    currentNode.next = root.right;
                    currentNode = currentNode.next;
                }

                root = root.next;
            }

            //moving to next level vertically
            root = tempNode.next;
        }
        return mainRoot;
    }
}
