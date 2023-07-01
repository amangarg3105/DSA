package maps;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CinemaAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int maximumFamilies = 0;
        Map<Integer, HashSet<Integer>> reservedSeatMap = new HashMap<>();


        for(int [] row : reservedSeats) {
            if(reservedSeatMap.containsKey(row[0])) {
                reservedSeatMap.get(row[0]).add(row[1]);
            } else {
                HashSet<Integer> seats = new HashSet<>();
                seats.add(row[1]);
                reservedSeatMap.put(row[0], seats);
            }
        }

        maximumFamilies = (n - reservedSeatMap.size()) * 2;

        for(Map.Entry<Integer, HashSet<Integer>> entry : reservedSeatMap.entrySet()) {
            HashSet<Integer> seats = entry.getValue();
            boolean isFamilySettled = false;
            if(!seats.contains(2) &&  !seats.contains(3) && !seats.contains(4) && !seats.contains(5)) {
                maximumFamilies++;
                isFamilySettled = true;
            }

            if(!seats.contains(6) &&  !seats.contains(7) && !seats.contains(8) && !seats.contains(9)) {
                maximumFamilies++;
                isFamilySettled = true;
            }

            if(!isFamilySettled) {
                if(!seats.contains(4) &&  !seats.contains(5) && !seats.contains(6) && !seats.contains(7)) {
                    maximumFamilies++;
                }
            }
        }

        return maximumFamilies;
    }
}
