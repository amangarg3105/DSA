package stack;


public class StackUsingArrays {


    int arr[];
    int top;

    public StackUsingArrays(int size) {
        arr = new int[size];
        top = -1;
    }

    public void push(int element) throws StackOverflowException {

        int stackSize = size();
        if(stackSize >= arr.length) {
            throw new StackOverflowException("You cannot push anymore elements in stack");
        }

        System.out.println("Pushing the element " + element + " into the stack");
        top++;
        arr[top] = element;
    }


    public int pop() throws StackUnderFlowException {

        if(isEmpty()) {
            throw new StackUnderFlowException("Stack is empty, cannot pop from an empty stack");
        }
        int element = arr[top];
        top--;
        return element;
    }

    public int peek() throws StackUnderFlowException {
        if(isEmpty()) {
            throw new StackUnderFlowException("Stack is empty, cannot pop in an empty stack");
        }
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
