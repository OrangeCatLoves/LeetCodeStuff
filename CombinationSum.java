import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Backtracking solution => Similar to brute force but can stop recursing if constraints are not met
        HashSet<List<Integer>> allSets = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        populateAns(allSets, candidates, target, list);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> l : allSets) {
            result.add(l);
        }
        return result;
    }

    public void populateAns(HashSet<List<Integer>> allSets, int[] candidates, int target, List<Integer> currList) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            Collections.sort(currList);
            allSets.add(currList);
        } else {
            for (int i = 0; i < candidates.length; i++) {
                List<Integer> nextList = new ArrayList<>(currList);
                nextList.add(candidates[i]);
                populateAns(allSets, candidates, target - candidates[i], nextList);
            }
        }
    }
}