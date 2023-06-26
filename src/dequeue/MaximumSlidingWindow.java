package dequeue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author amgarg
 */
public class MaximumSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int [] result = new int[nums.length - k + 1];

        int index  = 0;

        Deque<Integer> deque = new ArrayDeque<>();


        for(int currentEnd = 0; currentEnd < nums.length; currentEnd++) {
            int currentElement = nums[currentEnd];


            while(!deque.isEmpty() && nums[deque.peekLast()] < currentElement) {
                deque.removeLast();
            }

            while(!deque.isEmpty() && deque.peekFirst() < currentEnd - k + 1) {
                deque.removeFirst();
            }

            deque.addLast(currentEnd);

            if(currentEnd + 1 >=k ) {
                result[index] = nums[deque.peekFirst()];
                index++;
            }
        }

        return result;
    }
}
