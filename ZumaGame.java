class Solution {

    int result = -1;
    Set<String> alreadyChecked = new HashSet<>();

    public int findMinStep(String board, String hand) {
        // Receive a set of permutations of hand
        Set<String> handPermutations = new StringPermutations().permute(hand);
        for (String handSinlePermutation : handPermutations) {
            dfs(board, handSinlePermutation);
        }
        return result != -1 ? hand.length() - result : - 1;
    }

    private void dfs(String board, String charsLeft) {
        String memoKey = board + "#" + charsLeft;
        // If the current configuration of board and charsLeft has already been checked ||
        // There's no balls left to insert
        if (alreadyChecked.contains(memoKey) || charsLeft.length() <= result) {
            return;
        }

        char charToInsert = charsLeft.charAt(0);
        charsLeft = charsLeft.substring(1, charsLeft.length());

        for (int i = 1; i <= board.length(); i++) {
            if (!isGoodPlaceToInsert(board, i, charToInsert)) {
                continue;
            }
            String newBoard = add(board, charToInsert, i);
            newBoard = reduce(newBoard, i);
            if (newBoard.length() == 0) {
                result = Math.max(result, charsLeft.length());
            } else if (!charsLeft.isEmpty()) {
                dfs(newBoard, charsLeft);
            }
        }
        alreadyChecked.add(memoKey);
    }

    // Checks if there are 3 or more consecutive colors I can find
    private boolean isGoodPlaceToInsert(String board, int i, char charToInsert) {
        return board.charAt(i - 1) == charToInsert
                || (i >= 1 && i < board.length() && board.charAt(i) == board.charAt(i - 1));
    }

    // Gets the new board with the added new ball from hand
    private String add(String board, char c, int index) {
        StringBuilder out = new StringBuilder();
        out.append(board.substring(0, index));
        out.append(c);
        if (index < board.length()) {
            out.append(board.substring(index, board.length()));
        }
        return out.toString();
    }

    private String reduce(String board, int index) {
        char c = board.charAt(index);
        int left = index;
        while (left > 0 && board.charAt(left - 1) == c) {
            left--;
        }
        int right = index;
        while (right < board.length() - 1 && board.charAt(right + 1) == c) {
            right++;
        }
        // right - left + 1 is the number of same color consecutive balls
        if ((right - left + 1) >= 3) {
            board = remove(board, left, right);
            if (board.length() > 2) {
                int newIndex = (left != 0) ? left - 1 : left + 1;
                board = reduce(board, newIndex);
            }
        }
        return board;
    }

    // Remove the balls with similar consecutive colors
    private String remove(String board, int left, int right) {
        StringBuilder out = new StringBuilder();
        if (left >= 0) {
            out.append(board.substring(0, left));
        }
        if (right < board.length()) {
            out.append(board.substring(right + 1, board.length()));
        }
        return out.toString();
    }

    public class StringPermutations {

        // Generates a permutation of String text
        public Set<String> permute(String text) {
            Set<String> result = new HashSet<>();
            result.add(text);
            permutation(0, text.toCharArray(), result);
            return result;
        }

        private void permutation(int start, char[] chars, Set<String> result) {
            // Backtracking wishful thinking
            // Considering the first position, you swap with every other element inside the array
            // Call permutation() in a wishful way such that it handles every other permutation.
            // Then swap back to consider other paths that has not been considered
            for (int i = start; i <= chars.length - 1; i++) {
                swap(chars, start, i);
                /*
                if (i != start) {
                    result.add(new String(chars));
                }
                */
                permutation(start + 1, chars, result); // Call permutation() in a wishful way that it handles the rest of the permutation correctly
                if (i != start) {
                    result.add(new String(chars));
                }
                swap(chars, start, i);
            }
        }

        private void swap(char[] chars, int a, int b) {
            if (a == b) {
                return;
            }
            char temp = chars[b];
            chars[b] = chars[a];
            chars[a] = temp;
        }
    }
}