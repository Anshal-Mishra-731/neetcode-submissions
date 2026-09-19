class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(-1, 0, visited, mp)) {
            return false;
        }
        return visited.size() == n;
    }

    public boolean dfs(int vater, int key, Set<Integer> visited, Map<Integer, List<Integer>> mp) {
        visited.add(key);
        for (int i : mp.get(key)) {
            if (i == vater) continue;

            if (visited.contains(i)) {
                return false;
            }
            if (!dfs(key, i, visited, mp)) {
                return false;
            }
        }
        return true;
    }
}