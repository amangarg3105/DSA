package stack;


class Node {
    int minData;
    int data;

    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class MinStack {

    Node head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {

        if (head == null) {
            head = new Node(val);
            head.minData = val;
        } else {
            Node newNode = new Node(val);
            newNode.minData = Math.min(val, head.minData);
            newNode.next = head;
            head = newNode;
        }
    }

    public void pop() {

        head = head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.minData;
    }
}
