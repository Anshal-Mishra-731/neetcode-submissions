class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacQueue = new ArrayDeque<>();
        Queue<int[]> atlQueue = new ArrayDeque<>();

        for (int c = 0; c < n; c++) {
            pacific[0][c] = true;
            pacQueue.offer(new int[]{0, c});
            atlantic[m - 1][c] = true;
            atlQueue.offer(new int[]{m - 1, c});
        }

        for (int r = 0; r < m; r++) {
            if (!pacific[r][0]) {
                pacific[r][0] = true;
                pacQueue.offer(new int[]{r, 0});
            }
            if (!atlantic[r][n - 1]) {
                atlantic[r][n - 1] = true;
                atlQueue.offer(new int[]{r, n - 1});
            }
        }

        bfs(heights, pacQueue, pacific, m, n);
        bfs(heights, atlQueue, atlantic, m, n);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] reachable, int m, int n) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n  && !reachable[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    reachable[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}