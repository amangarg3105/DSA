package linkedlists;

import java.util.Stack;

class DLLNode {
    String url;

    DLLNode next;
    DLLNode prev;

    public DLLNode(String url) {
        this.url = url;
    }
}

public class BrowserHistory {


    DLLNode currentNode;

    public BrowserHistory(String homepage) {

        currentNode = new DLLNode(homepage);
    }

    public void visit(String url) {

        currentNode.next = new DLLNode(url);
        currentNode.next.prev = currentNode;
        currentNode = currentNode.next;
    }

    public String back(int steps) {

        while(currentNode.prev != null && steps > 0) {
            currentNode = currentNode.prev;
            steps--;
        }
        return currentNode.url;
    }

    public String forward(int steps) {
        while(currentNode.next != null && steps > 0) {
            currentNode = currentNode.next;
            steps--;
        }
        return currentNode.url;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }
}
