package heaps;

import java.util.ArrayList;

/**
 * @author amgarg
 */
public class MinHeap {

    private ArrayList<Integer> dataList;

    MinHeap() {
        dataList = new ArrayList<>();
        dataList.add(null);
    }




    public void insert(int element) {
        dataList.add(element);

        int currentIndex = dataList.size() - 1;
        int parentIndex = currentIndex / 2;


        while (currentIndex != 1) {

            int currentData = dataList.get(currentIndex);
            int parentData = dataList.get(parentIndex);

            if (currentData >= parentData) {
                return;
            }

            //swap
            dataList.set(currentIndex, parentData);
            dataList.set(parentIndex, currentData);

            currentIndex = parentIndex;
            parentIndex = currentIndex / 2;
        }
    }

    public int getMin() {
        return dataList.get(1);
    }

    public int removeMin() {
        int min = dataList.get(1);

        int lastElement = dataList.get(dataList.size() - 1);
        dataList.set(1, lastElement);
        dataList.remove(dataList.size() - 1);

        //heapify
        int currentIndex = 1;
        int leftChildIndex = currentIndex * 2;
        int rightChildIndex = leftChildIndex + 1;


        while (leftChildIndex < dataList.size() - 1) {
            int minimumIndex = currentIndex;
            int currentData = dataList.get(currentIndex);

            int leftChildData = dataList.get(leftChildIndex);


            if (leftChildData < currentData) {
                minimumIndex = leftChildIndex;
            }


            if (rightChildIndex < dataList.size()) {
                int rightChildData = dataList.get(rightChildIndex);
                if (rightChildData < dataList.get(minimumIndex)) {
                    minimumIndex = rightChildIndex;
                }
            }

            if(minimumIndex == currentIndex) {
                break;
            }
            //swap
            dataList.set(currentIndex, dataList.get(minimumIndex));
            dataList.set(minimumIndex, currentData);

            currentIndex = minimumIndex;
            leftChildIndex = currentIndex * 2;
            rightChildIndex = leftChildIndex + 1;

        }
        return min;
    }

    public boolean isEmpty() {
        return dataList.size() == 1;
    }

    public int size () {
        return dataList.size() - 1;
    }
}
