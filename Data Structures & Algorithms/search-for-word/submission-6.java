class Solution {
    public boolean exist(char[][] board, String word) {
        Set<Pair<Integer, Integer>> st = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backt(board, word, st, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backt(char[][] board, String word, Set<Pair<Integer, Integer>> st, int i, int j, int idx) {
        if (board[i][j] != word.charAt(idx) || st.contains(new Pair<>(i, j))) {
            return false;
        }

        if(idx == word.length() - 1){
            return true;
        }

        st.add(new Pair<>(i, j));
        if (i + 1 < board.length) {
            if (backt(board, word, st, i + 1, j, idx + 1)) {
                return true;
            }
        }
        if (j + 1 < board[0].length) {
            if (backt(board, word, st, i, j + 1, idx + 1)) {
                return true;
            }
        }
        if (i - 1 >= 0) {
            if (backt(board, word, st, i - 1, j, idx + 1)) {
                return true;
            }
        }
        if (j - 1 >= 0) {
            if (backt(board, word, st, i, j - 1, idx + 1)) {
                return true;
            }
        }
        st.remove(new Pair<>(i, j));

        return false;
    }
}