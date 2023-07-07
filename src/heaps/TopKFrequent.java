package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {

            int currentNumber = nums[index];
            if (freqMap.containsKey(currentNumber)) {
                int existingFrequency = freqMap.get(currentNumber);
                existingFrequency++;
                freqMap.put(currentNumber, existingFrequency);
            } else {
                freqMap.put(currentNumber, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue()
                - a.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            maxHeap.add(entry);
        }


        int result[] = new int[k];
        int count = 0;
        while (count < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll(); //1 -> 5
            result[count] = entry.getKey();
            count++;
        }

        return result;

    }

    public static void main(String[] args) {


        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(1);
        pq.add(10);
        pq.add(2);

        Integer remove = pq.remove();
        System.out.println(remove);

        pq.add(15);

        remove = pq.remove();
        System.out.println(remove);


        remove = pq.remove();
        System.out.println(remove);


        //max
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        maxHeap.add(5);
        maxHeap.add(10);
        maxHeap.add(1);

        System.out.println(maxHeap.remove());

        System.out.println(maxHeap.remove());


    }


}
