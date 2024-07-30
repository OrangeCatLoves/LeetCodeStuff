class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int m = people.size();
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }
        int[] skillMask = new int[m];
        for (int i = 0; i < m; i++) {
            List<String> skills = people.get(i);
            int mask = 0;
            for (String skill : skills) {
                mask |= 1 << skillIndex.get(skill);
            }
            skillMask[i] = mask;
        }
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int mask = skillMask[i];
            if (mask == 0) continue;
            for (int j = 0; j < (1 << n); j++) {
                if (dp[j] == null) continue;
                int newMask = j | mask;
                if (dp[newMask] == null || dp[newMask].size() > dp[j].size() + 1) {
                    dp[newMask] = new ArrayList<>(dp[j]);
                    dp[newMask].add(i);
                }
            }
        }
        List<Integer> result = dp[(1 << n) - 1];
        int[] team = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            team[i] = result.get(i);
        }
        return team;
    }
}