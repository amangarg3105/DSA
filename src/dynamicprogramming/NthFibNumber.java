package dynamicprogramming;


import java.util.Arrays;

public class NthFibNumber {

    public static int fibUsingRecursion(int n) {

        if (n < 2) {
            return n;
        }


        int smallOutput1 = fibUsingRecursion(n - 1);
        int smallOutput2 = fibUsingRecursion(n - 2);


        return smallOutput1 + smallOutput2;
    }


    public static int topDownFib(int n, int [] dpMemory) {


        //base condition
        if(n < 2) {
            dpMemory[n] = n;
            return n;
        }


        //Asking my past
        if(dpMemory[n] != -1) {
            return dpMemory[n];
        }


        //Solving the subproblem
        int smallOutput1 = topDownFib(n - 1, dpMemory);
        int smallOutput2 = topDownFib(n - 2, dpMemory);


        dpMemory[n] = smallOutput1 + smallOutput2;
        return dpMemory[n];

    }


    public static int bottomUp(int n) {

        int [] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(fibUsingRecursion(8));

        int [] dpMemory = new int[9];
        Arrays.fill(dpMemory, -1);

        System.out.println(topDownFib(8, dpMemory));

        System.out.println(bottomUp(8));
    }
}
