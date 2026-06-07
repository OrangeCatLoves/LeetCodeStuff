class Solution {
    public int partitionString(String s) {
        Set<Character> seen = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!seen.contains(c)) {
                seen.add(c);
            } else {
                count++;
                seen.clear();
                seen.add(c);
            }
        }
        return count + 1;
    }
}
