package backtracking;


import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        helper(s, tempList, result, 0);
        return result;
    }

    private void helper(String s, List<String> tempList, List<String> result, int start) {
        if (tempList.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", tempList));
                return;
            }
        }

        for (int j = start + 1; j <= start + 3 && j < s.length(); j++) {

            String val = s.substring(start, j);

            if (Integer.parseInt(val) <= 255 && (val.equals("0") || !val.startsWith("0"))) {
                tempList.add(val);
                helper(s, tempList, result, j);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
