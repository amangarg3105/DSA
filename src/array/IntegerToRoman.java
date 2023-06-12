package array;


public class IntegerToRoman {

    /**
     * T.C = O(num)
     * S.C = O(1)
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        int [] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


        String [] romans =
                {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV",
                        "I"};

        String romanRepresentation = "";

        for(int i = 0;  i < numbers.length; i++) {
            while(num >= numbers[i]) {
                romanRepresentation = romanRepresentation + romans[i];
                num = num - numbers[i];
            }
        }

        return romanRepresentation;

    }
}
