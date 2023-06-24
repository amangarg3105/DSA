package stack;


public class StackUse {

    public static void main(String[] args) throws StackUnderFlowException, StackOverflowException {
        StackUsingArrays stack = new StackUsingArrays(5);

        stack.push(5);

        stack.push(1);


        stack.push(100);

        stack.push(1);

        stack.pop();

        System.out.println(stack.peek());






    }
}
