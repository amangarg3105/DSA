package heaps;

/**
 * @author amgarg
 */
public class MinHeapUse {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(20);

        minHeap.insert(23);

        minHeap.insert(21);
        minHeap.insert(30);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(10);


        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.removeMin());
        }
    }
}
