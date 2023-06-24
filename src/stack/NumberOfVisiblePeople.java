package stack;

import java.util.Stack;

/**
 * @author amgarg
 */
public class NumberOfVisiblePeople {

    public int[] canSeePersonsCount(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int [] result = new int[heights.length];

        for(int index = heights.length - 1; index >= 0; index--) {
            int currentHeight = heights[index];

            int visibilityCount = 0;
            while(!stack.isEmpty() && currentHeight > stack.peek())  {
                stack.pop();
                visibilityCount++;
            }

            if(!stack.isEmpty()) {
                visibilityCount++;
            }

            stack.push(currentHeight);
            result[index] = visibilityCount;
        }
        return result;
    }

}
