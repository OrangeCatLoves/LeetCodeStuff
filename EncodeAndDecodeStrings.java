import java.util.List;
import java.util.ArrayList;

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sbr = new StringBuilder("");
        // "," functions as a delimiter in this case
        for (String s: strs) {
            if (!s.equals(",")) {
                sbr.append(s).append(",");
            } else { // ",(marks the start),(indicates that it is),(actual str starts here),(marks the end)"
                sbr.append(",").append(s).append(",");
            }
        }
        System.out.println(sbr.toString());
        return sbr.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int maxLen = str.length();
        while (end < maxLen) {
            if (str.charAt(end) != ',') {
                end++;
            } else {
                result.add(str.substring(start, end));
                end++;
                start = end;
            }
        }
        return result;
    }
}