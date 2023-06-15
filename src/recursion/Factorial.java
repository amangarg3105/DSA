package recursion;


public class Factorial {

    public static int fact(int n) {



        int smallAns = fact(n - 1);

        int mainAns = smallAns * n;
        return mainAns;

    }

    public static void main(String[] args) {

        System.out.println(fact(5));

    }
}
