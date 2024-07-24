import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int currLongestLen = 0;
        int currLen = 0;
        HashSet hashset = new HashSet<>();
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int count = 0; // Should represent the index of a a character + act as a terminating condition
        while (count != len) {
            int ASCIIVal = (int) s.charAt(count);
            if (hashset.contains(ASCIIVal)) {
                //System.out.println("contains");
                if (currLen > currLongestLen) {
                    currLongestLen = currLen;
                }
                currLen = 0;
                hashset = new HashSet<>();
                int temp = hashmap.get(ASCIIVal);
                hashmap = new HashMap<Integer, Integer>();
                count = temp + 1;
            } else {
                //System.out.println("not contains");
                hashmap.put(ASCIIVal, count);
                hashset.add(ASCIIVal);
                count++;
                currLen++;
                if (currLen > currLongestLen) {
                    currLongestLen = currLen;
                }
            }
        }
        return currLongestLen;
    }
}