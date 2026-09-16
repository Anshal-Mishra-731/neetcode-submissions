class Solution {
    public int numIslands(char[][] grid) {
        Set<String> seen = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if (isValid(i, j, grid, seen)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isValid(int i, int j, char[][] grid, Set<String> seen) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }

        if (grid[i][j] == '0') {
            return false;
        }

        String pos = i + "," + j;
        if (seen.contains(pos)) {
            return false;
        }

        seen.add(pos);

        isValid(i - 1, j, grid, seen);
        isValid(i + 1, j, grid, seen);
        isValid(i, j - 1, grid, seen);
        isValid(i, j + 1, grid, seen);

        return true;
    }
}