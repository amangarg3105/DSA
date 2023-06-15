package recursion;


public class GenerateParenthesis {

    public static void printBalanceParenthesis(int open, int close, String output) {

        if(close < open) {
            return;
        }

        if(open == 0 && close == 0) {
            System.out.println(output);
            return;
        }
        if(open > 0) {
            String parenthesisString = output + "(";
            printBalanceParenthesis(open - 1, close, parenthesisString);
        }


        if(close > 0) {
            String parenthesisString = output + ")";
            printBalanceParenthesis(open, close - 1, parenthesisString);
        }
    }


    public static void main(String[] args) {
        printBalanceParenthesis(2, 2, "");
    }
}
