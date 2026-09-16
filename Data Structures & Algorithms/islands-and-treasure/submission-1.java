class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    q.offer(new Pair<>(i, j));
                }
            }
        }

        bfs(grid, q);
    }

    public void bfs(int[][] grid, Queue<Pair<Integer, Integer>> q){
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int k = 0; k < size; k++){
                Pair<Integer,Integer> curr = q.poll();
                int i = curr.getKey();
                int j = curr.getValue();

                if(i + 1 < grid.length && grid[i + 1][j] == Integer.MAX_VALUE){
                    grid[i+1][j] = dist + 1;
                    q.offer(new Pair<>(i + 1, j));
                }
                if(i - 1 >= 0 && grid[i - 1][j] == Integer.MAX_VALUE){
                    grid[i-1][j] = dist + 1;
                    q.offer(new Pair<>(i - 1, j));
                }
                if(j + 1 < grid[0].length && grid[i][j + 1] == Integer.MAX_VALUE){
                    grid[i][j + 1] = dist + 1;
                    q.offer(new Pair<>(i, j + 1));
                }
                if(j - 1 >= 0 && grid[i][j - 1] == Integer.MAX_VALUE){
                    grid[i][j - 1] = dist + 1;
                    q.offer(new Pair<>(i, j - 1));
                }
            }

            dist++;
        }
    }
}