package recursion;


import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {


    public static String getValue(char c) {

        if (c == '2') {
            return "abc";
        }

        if (c == '3') {
            return "def";
        }

        if (c == '4') {
            return "ghi";
        }

        if (c == '5') {
            return "jkl";
        }

        if (c == '6') {
            return "mno";
        }

        if (c == '7') {
            return "pqrs";
        }

        if (c == '8') {
            return "tuv";
        }

        if (c == '9') {
            return "wxyz";
        }

        return "";
    }

    public List<String> letterCombinations(String digits) { //53


        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String firstDigitValue = getValue(digits.charAt(0)); //abc,     jkl     def

        List<String> smallerAns = letterCombinations(digits.substring(1));//[]  [d,e,f] , //[jd, je, jf, kd, ke, kf, ld, le, lf]

        if (smallerAns.size() == 0) {
            smallerAns.add("");
        }
        List<String> mainAns = new ArrayList<>(); //[]

        for (int i = 0; i < firstDigitValue.length(); i++) { //abc
            for (int j = 0; j < smallerAns.size(); j++) {  //[jd, je, jf, kd, ke, kf, ld, le, lf]
                String mainCombination = firstDigitValue.charAt(i) + smallerAns.get(j);
                mainAns.add(mainCombination);
            }
        }

        return mainAns; //[d, e, f] , //[jd, je, jf, kd, ke, kf, ld, le, lf]
    }
}
