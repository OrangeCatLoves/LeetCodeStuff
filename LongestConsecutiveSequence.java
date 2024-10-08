import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==1||nums.length==0){
            return nums.length;
        }
        HashSet<Integer> hm=new HashSet<>();
        int count=1;
        int ans=1;
        for(int i=0;i<nums.length;i++){
            hm.add(nums[i]);
        }
        for (Integer it : hm) {
            if (hm.contains(it - 1)) {
                continue;
            }
            int nextVal = it + 1;
            if (hm.contains(nextVal)) {
                count = 1; // Reset count for a new sequence
                while (hm.contains(nextVal)) {
                    count++;
                    nextVal++;
                }
                ans = Math.max(ans, count);
            } else {
                count = 1; // Since nextVal wasn't there, this element is not part of a sequence. Reset count to 1.
            }
        }
        return ans;
    }
}