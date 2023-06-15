package searching;

import java.util.Arrays;

/**
 * @author amgarg
 */
public class Heaters {


    /**
     * T.C - O(nlogm) where n is houses.length & m is heaters.length
     * S.C - O(1)
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {


        Arrays.sort(heaters);

        int radius = 0;

        for(int index = 0; index < houses.length; index++) {
            int currentHouse = houses[index];

            int nearestHeaterRadius =
                    findNearestHeater(currentHouse, heaters);

            if(radius < nearestHeaterRadius) {
                radius = nearestHeaterRadius;
            }

        }
        return radius;
    }

    private int findNearestHeater(int currentHouse, int[] heaters) {

        int start = 0, end = heaters.length -1, nearestHeaterRadius = Integer.MAX_VALUE;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(heaters[mid] == currentHouse) {
                return 0;
            }

            if(heaters[mid] > currentHouse) {
                int nearestRadiusInRightDirection = heaters[mid] - currentHouse;
                nearestHeaterRadius = Math.min(nearestHeaterRadius, nearestRadiusInRightDirection);
                end = mid - 1;
            } else {
                int nearestRadiusInLeftDirection = currentHouse - heaters[mid];
                nearestHeaterRadius = Math.min(nearestHeaterRadius, nearestRadiusInLeftDirection);
                start = mid  + 1;
            }
        }
        return nearestHeaterRadius;
    }


}
