package maps;

import java.util.HashMap;


public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;

        int start = 0;
        for(int i = 0; i < s.length(); i++) {

            if(map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
