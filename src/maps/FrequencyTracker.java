package maps;


import java.util.HashMap;
import java.util.HashSet;

public class FrequencyTracker {


    /*
    this map stores the freq. of a given number
     */
    HashMap<Integer, Integer> freqMap;

    /*
    this map stores the numbers against the frequencies.
     */
    HashMap<Integer, HashSet<Integer>> freqToNumbersMap;

    public FrequencyTracker() {
        freqMap = new HashMap<>();
        freqToNumbersMap = new HashMap<>();
    }

    public void add(int number) {

        int oldFreq = freqMap.getOrDefault(number, 0);
        int newFreq = oldFreq + 1;
        freqMap.put(number, newFreq);


        if(freqToNumbersMap.containsKey(oldFreq)) {
            HashSet<Integer> numbersSet = freqToNumbersMap.get(oldFreq);
            numbersSet.remove(number);
        } else {
            freqToNumbersMap.put(oldFreq, new HashSet<>());
        }

        if(freqToNumbersMap.containsKey(newFreq)) {
            HashSet<Integer> numbersSet = freqToNumbersMap.get(newFreq);
            numbersSet.add(number);
        } else {
            freqToNumbersMap.put(newFreq, new HashSet<>());
            HashSet<Integer> numbersSet = freqToNumbersMap.get(newFreq);
            numbersSet.add(number);
        }
    }

    public void deleteOne(int number) {
        if(freqMap.containsKey(number)) {
            int oldFreq = freqMap.getOrDefault(number, 0);
            int newFreq = oldFreq - 1;
            freqMap.put(number, newFreq);


            if(freqToNumbersMap.containsKey(oldFreq)) {
                HashSet<Integer> numbersSet = freqToNumbersMap.get(oldFreq);
                numbersSet.remove(number);
            } else {
                freqToNumbersMap.put(oldFreq, new HashSet<>());
            }

            if(newFreq > 0) {
                if(freqToNumbersMap.containsKey(newFreq)) {
                    HashSet<Integer> numbersSet = freqToNumbersMap.get(newFreq);
                    numbersSet.add(number);
                } else {
                    freqToNumbersMap.put(newFreq, new HashSet<>());
                    HashSet<Integer> numbersSet = freqToNumbersMap.get(newFreq);
                    numbersSet.add(number);
                }
            } else {
                freqMap.remove(number);
            }


        }
    }

    public boolean hasFrequency(int frequency) {

        if(freqToNumbersMap.containsKey(frequency) && !freqToNumbersMap.get(frequency).isEmpty()) {
            return true;
        }
        return false;
    }
}
