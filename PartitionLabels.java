class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> l = new ArrayList<>();
        int index = 0; // Represents the current highest index so far
        for (int i = 0; i < s.length(); i+=index) {
            index = s.lastIndexOf(s.charAt(i));
            for (int j = i; j < index; j++) {
                int lastIndex = s.lastIndexOf(s.charAt(j));
                if (lastIndex > index) {
                    index = lastIndex;
                }
            }
            index = index - i + 1;
            l.add(index);
        }
        return l;
    }
}