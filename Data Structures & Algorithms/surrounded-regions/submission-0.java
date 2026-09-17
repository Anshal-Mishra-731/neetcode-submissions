class Solution {
    public void solve(char[][] board) {
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(i == 0 || i == board.length - 1 || j == 0 || j == board[0].length -1){
                    if(board[i][j] == 'O'){
                        q.offer(new Pair<>(i, j));
                    }
                }
            }
        }

        bfs(q, board);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'W'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void bfs(Queue<Pair<Integer, Integer>> q, char[][] board){
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                Pair<Integer, Integer> curr = q.poll();
                int i = curr.getKey(); 
                int j = curr.getValue();

                board[i][j] = 'W';

                if(i + 1 < board.length && board[i+1][j] == 'O'){
                    board[i+1][j] = 'W';
                    q.offer(new Pair<>(i+1, j));
                }
                if(i - 1 >= 0 && board[i-1][j] == 'O'){
                    board[i-1][j] = 'W';
                    q.offer(new Pair<>(i-1, j));
                }
                if(j + 1 < board[0].length && board[i][j+1] == 'O'){
                    board[i][j+1] = 'W';
                    q.offer(new Pair<>(i, j+1));
                }
                if(j - 1 >= 0 && board[i][j -1] == 'O'){
                    board[i][j -1] = 'W';
                    q.offer(new Pair<>(i, j -1));
                }
            }
        }
    }
}
