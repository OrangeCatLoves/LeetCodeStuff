import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Helper(nums, result, currList);
        return result;
    }

    private void Helper(int[] nums, List<List<Integer>> result, List<Integer> currList) {
        if (currList.size() == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i : nums) {
            if (currList.contains(i)) {
                continue;
            }
            currList.add(i);
            Helper(nums, result, currList);
            currList.remove(currList.size() - 1);
        }
    }
}