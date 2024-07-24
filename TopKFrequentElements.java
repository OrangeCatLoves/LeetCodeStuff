import java.util.HashMap;
import java.util.ArrayList;


public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        // Either updates the Entry inside the hashmap or it creates a new Entry
        // + 1 to the count (frequency) each time
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0) + 1);
        }
        // Each index in the arrList represents the frequency of the character appearing. The list for that index
        // Should contain all the numbers with that frequency in the nums array
        ArrayList<Integer>[] freqArr = new ArrayList[nums.length + 1];
        for (int key: hashmap.keySet()) {
            int freq = hashmap.get(key);
            if (freqArr[freq] == null) {
                ArrayList<Integer> arrList = new ArrayList<>();
                freqArr[freq] = arrList;
                freqArr[freq].add(key);
            } else {
                freqArr[freq].add(key);
            }
        }
        int[] result = new int[k];
        int count = 0;
        // The error was here. i = nums.length when it should be freqArr.length
        for (int i = freqArr.length - 1 ; i >= 0; i--) {
            if (freqArr[i] != null) {
                for (int j = 0; j < freqArr[i].size() && count < k; j++) {
                    result[count] = freqArr[i].get(j);
                    count++;
                }
            }
        }
        return result;
    }
}
