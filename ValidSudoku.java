class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rowsDup = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> colsDup = new ArrayList<HashSet<Character>>();
        ArrayList<ArrayList<HashSet<Character>>> subGroupDup = new ArrayList<ArrayList<HashSet<Character>>>();
        for (int i = 0; i < 9; i++) {
            rowsDup.add(new HashSet<Character>());
            colsDup.add(new HashSet<Character>());
        }
        for (int i = 0; i < 3; i++) {
            subGroupDup.add(new ArrayList<HashSet<Character>>());
            for (int j = 0; j < 3; j++) {
                subGroupDup.get(i).add(new HashSet<Character>());
            }
        }
        HashSet<Character> currRowSet;
        HashSet<Character> currColSet;
        HashSet<Character> currSubGroupSet; 
        for (int i = 0; i < 9; i++) { // row
            for (int j = 0; j < 9; j++) { // col
                if (board[i][j] == '.') {
                    continue;
                }
                currRowSet = rowsDup.get(i);
                currColSet = colsDup.get(j);
                currSubGroupSet = subGroupDup.get((int)Math.floor(i/3)).get((int)Math.floor(j/3));
                if (!currRowSet.contains(board[i][j])) {
                    currRowSet.add(board[i][j]);
                } else {
                    return false;
                }

                if (!currColSet.contains(board[i][j])) {
                    currColSet.add(board[i][j]);
                } else {
                    return false;
                }

                if (!currSubGroupSet.contains(board[i][j])) {
                    currSubGroupSet.add(board[i][j]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
