class Solution {
    public boolean exist(char[][] board, String word) {
        Set<String> st = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (backt(board, word, st, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backt(char[][] board, String word, Set<String> st,
                         int i, int j, int idx) {

        String pos = i + "," + j;

        if (board[i][j] != word.charAt(idx) || st.contains(pos)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        st.add(pos);

        if (i + 1 < board.length) {
            if (backt(board, word, st, i + 1, j, idx + 1)) {
                st.remove(pos);
                return true;
            }
        }

        if (j + 1 < board[0].length) {
            if (backt(board, word, st, i, j + 1, idx + 1)) {
                st.remove(pos);
                return true;
            }
        }

        if (i - 1 >= 0) {
            if (backt(board, word, st, i - 1, j, idx + 1)) {
                st.remove(pos);
                return true;
            }
        }
        if (j - 1 >= 0) {
            if (backt(board, word, st, i, j - 1, idx + 1)) {
                st.remove(pos);
                return true;
            }
        }
        st.remove(pos);

        return false;
    }
}