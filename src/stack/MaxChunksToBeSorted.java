package stack;


import java.util.Stack;

public class MaxChunksToBeSorted {

    public int maxChunksToSorted(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for(int index = 0; index < arr.length; index++) {
            int currentElement = arr[index];

            if(stack.isEmpty() || stack.peek() < currentElement) {
                stack.push(currentElement);
            } else {
                int max = currentElement;
                while(!stack.empty() && stack.peek() > currentElement) {
                    max = Math.max(max, stack.pop());
                }
                stack.push(max);
            }

        }
        return stack.size();
    }
}
