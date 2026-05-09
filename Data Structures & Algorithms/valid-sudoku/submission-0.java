class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> seti = new HashSet<>();
            List<Character> arr = new ArrayList<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    seti.add(board[i][j]);
                    arr.add(board[i][j]);
                }
            }
            if (seti.size() != arr.size()) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            Set<Character> seti = new HashSet<>();
            List<Character> arr = new ArrayList<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    seti.add(board[j][i]);
                    arr.add(board[j][i]);
                }
            }
            if (seti.size() != arr.size()) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                Set<Character> seti = new HashSet<>();
                List<Character> arr = new ArrayList<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            seti.add(board[k][l]);
                            arr.add(board[k][l]);
                        }
                    }
                }
                if (seti.size() != arr.size()) {
                    return false;
                }
            }
        }

        return true;
    }
}