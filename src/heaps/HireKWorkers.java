package heaps;


import java.util.PriorityQueue;

public class HireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {


        int i = 0;
        int j = costs.length - 1;

        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>();

        int session = 0;
        int totalCost = 0;
        while (session < k) {

            while (minHeap1.size() < candidates && i <= j) {
                minHeap1.add(costs[i]);
                i++;
            }

            while (minHeap2.size() < candidates && j >= i) {
                minHeap2.add(costs[j]);
                j--;
            }


            int firstMinCost = Integer.MAX_VALUE;
            if (minHeap1.size() > 0) {
                firstMinCost = minHeap1.peek();
            }

            int secondMinCost = Integer.MAX_VALUE;

            if (minHeap2.size() > 0) {
                secondMinCost = minHeap2.peek();
            }

            if(firstMinCost <= secondMinCost) {
                totalCost += firstMinCost;
                minHeap1.poll();
            } else {
                totalCost += secondMinCost;
                minHeap2.poll();
            }
            session++;
        }
        return totalCost;
    }
}
