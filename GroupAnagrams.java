import java.util.ArrayList;
import java.util.Hashtable;

class Solution {

    /* This solution failed Test Case 98 because "Ken" and "Ken" are not sorted such that they're adjacent to each other,
    hence it failed. Could implement internal lexicographical sort but probably will get TLE
    */

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Hashtable<Integer, List<String>> hashtable = new Hashtable<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int hash = hashFunc(strs[i]);
            if (!hashtable.containsKey(hash)) {
                List<String> arrList = new ArrayList<>();
                arrList.add(strs[i]);
                hashtable.put(hash, arrList);
                ans.add(arrList);
            } else {
                hashtable.get(hash).add(strs[i]);
            }
        }
        return ans;
    }

    public int hashFunc(String s) {
        final int MOD = 1000000007;
        long hashValue = 0;
        int[] freq = new int[26];
        for (char k: s.toCharArray()) {
            freq[k-'a'] += 1;
        }
        for (int k: freq) {
            hashValue = hashValue * 101 + k;
            hashValue %= MOD;
        }
        return (int)hashValue;
    }

    public boolean areAnagrams(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 != len2) {
            return false;
        }
        int[] histogram1 = new int[128];
        int[] histogram2 = new int[128];
        for (int i = 0; i < 128; i++) {
            histogram1[i] = 0;
            histogram2[i] = 0;
        }
        for (int i = 0; i < len1; i++) {
            int index = (int) str1.charAt(i);
            histogram1[index]++;
        }
        for (int i = 0; i < len2; i++) {
            int index = (int) str2.charAt(i);
            histogram2[index]++;
        }
        for (int i = 0; i < 128; i++) {
            if (histogram1[i] != histogram2[i]) {
                return false;
            }
        }
        return true;
    }
}