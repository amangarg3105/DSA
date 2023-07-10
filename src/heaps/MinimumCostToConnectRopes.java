package heaps;


import java.util.PriorityQueue;

public class MinimumCostToConnectRopes {

    public static int connect(int [] ropes) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int totalCost = 0;

        for(int ropeLength : ropes) {
            minHeap.add(ropeLength);
        }

        while (minHeap.size() > 1) {

            int firstNumber = minHeap.poll();
            int secondNumber = minHeap.poll();

            int sum = firstNumber + secondNumber;

            minHeap.add(sum);

            totalCost += sum;
        }
        return totalCost;
    }


    public static void main(String[] args) {
        int [] array = {5, 4, 3, 9};
//7, 12, 21
        System.out.println(connect(array));
    }
}
