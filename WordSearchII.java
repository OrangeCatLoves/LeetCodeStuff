import java.util.ArrayList;
import java.util.List;

class Solution {
    /*public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        List<String> result = new ArrayList<>();
        boolean toAddOrNot = true;
        for (int i = 0; i < words.length; i++) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (board[r][c] == words[i].charAt(0)) { // Found the starting character in the word
                        int currIndex = 1; // Position of char in the string
                        // variable r and c indicates the row and column you're currently at in the matrix
                        while (currIndex < words[i].length()) {
                            if (r - 1 > 0 && board[r - 1][c] == words[i].charAt(currIndex)) { // Go Up
                                currIndex++;
                            } else if (c + 1 < col && board[r][c + 1] == words[i].charAt(currIndex)) { // Go Right
                                currIndex++;
                            } else if (r + 1 < row && board[r + 1][c] == words[i].charAt(currIndex)) { // Go Down
                                currIndex++;
                            } else if (c - 1 > 0 && board[r][c - 1] == words[i].charAt(currIndex)) { // Go Left
                                currIndex++;
                            } else {
                                toAddOrNot = false;
                            }
                        }
                        if (toAddOrNot) {
                            result.add(words[i]);
                            toAddOrNot = true;
                        }
                    }
                }
            }
        }
        return result;
    }*/

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

