package heaps;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFlood {

    public int[] avoidFlood(int[] rains) {

        int [] result = new int[rains.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < rains.length; i++) {

            //dry day
            if (rains[i] == 0) {
                dryDays.add(i);
            } else {
                if (map.containsKey(rains[i])) {
                    Integer justNextDryDay = dryDays.ceiling(map.get(rains[i]));

                    if (justNextDryDay == null) {
                        return new int[0];
                    }

                    result[justNextDryDay] = rains[i];

                    dryDays.remove(justNextDryDay);
                }

                result[i] = -1;
                map.put(rains[i], i);
            }

        }
        return result;
    }
}
