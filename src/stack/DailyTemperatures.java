package stack;

import java.util.Stack;

public class DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int [] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {

            int currentTemperature = temperatures[i];
            while(!stack.isEmpty() && currentTemperature > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }
        return result;
    }
}
