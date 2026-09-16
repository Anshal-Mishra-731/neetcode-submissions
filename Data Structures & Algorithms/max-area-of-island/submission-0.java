class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(i, j, grid, seen));
                }
            }
        }

        return res;
    }

    public int dfs(int i, int j, int[][] grid, Set<String> seen){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        String pos = i + "," + j;
        if(seen.contains(pos)){
            return 0;
        }

        seen.add(pos);

        int up = dfs(i - 1, j, grid, seen);
        int right = dfs(i + 1, j, grid, seen);
        int down = dfs(i, j - 1, grid, seen);
        int left = dfs(i, j + 1, grid, seen);

        return 1 + up + right + down + left;
    }
}
