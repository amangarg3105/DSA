package dynamicprogramming;

import java.util.Arrays;

/**
 * @author amgarg
 */
public class MinDenominations {

    public static int minDenominationsUsingRecursion(int [] denominations, int amount) {


        if (amount == 0) {
            return 0;
        }

        int minDenominationsRequired = Integer.MAX_VALUE;

        for (int i = 0; i < denominations.length; i++) {

            int currentDenominationValue = denominations[i];
            int remainingAmount = amount - currentDenominationValue;

            if (remainingAmount >= 0) {
                int restOfDenominations = minDenominationsUsingRecursion(denominations, remainingAmount);
                minDenominationsRequired = Math.min(minDenominationsRequired, restOfDenominations + 1);
            }
        }

        return minDenominationsRequired;

    }


    public static int minCoinsUsingMemo(int [] denominations, int amount, int [] dpMemory) {

        if(amount == 0) {
            return dpMemory[amount];
        }

        //Asking my past
        if (dpMemory[amount] != 0) {
            return dpMemory[amount];
        }

        //solving the subproblem
        int minDenominationsRequired = Integer.MAX_VALUE;

        for (int i = 0; i < denominations.length; i++) {

            int currentDenominationValue = denominations[i];
            int remainingAmount = amount - currentDenominationValue;

            if (remainingAmount >= 0) {
                int restOfDenominations = minCoinsUsingMemo(denominations, remainingAmount, dpMemory);
                minDenominationsRequired = Math.min(minDenominationsRequired, restOfDenominations + 1);
            }
        }
        dpMemory[amount] = minDenominationsRequired;
        return dpMemory[amount];
    }



    public static void main(String[] args) {

        int [] denominations = {1, 7, 10};

        int amount = 22;

        int [] dpMemory = new int[amount + 1];

        System.out.println(minCoinsUsingMemo(denominations, amount, dpMemory));
    }
}
