class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = -1;
        int fresh = 0;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair<>(i, j));
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(q.isEmpty() && fresh == 0) return 0;

        return bfs(q, grid, ans, fresh);
    }

    public int bfs(Queue<Pair<Integer, Integer>> q, int[][] grid, int ans, int fresh){
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int k = 0; k < size; k++){
                Pair<Integer, Integer> curr = q.poll();
                int i = curr.getKey();
                int j = curr.getValue();

                if(i + 1 < grid.length && grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    fresh--;
                    q.offer(new Pair<>(i+1, j));
                }

                if(i - 1 >= 0 && grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    fresh--;
                    q.offer(new Pair<>(i-1, j));
                }

                if(j + 1 < grid[0].length && grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    fresh--;
                    q.offer(new Pair<>(i, j+1));
                }

                if(j - 1 >= 0 && grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    fresh--;
                    q.offer(new Pair<>(i, j-1));
                }
            }
        }

        if(fresh > 0) return -1;

        return ans;
    }
}