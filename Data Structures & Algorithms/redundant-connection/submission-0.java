class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] edge : edges) {
            mp.putIfAbsent(edge[0], new ArrayList<>());
            mp.putIfAbsent(edge[1], new ArrayList<>());

            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);
            Set<Integer> visited = new HashSet<>();
            if (!dfs(-1, edge[0], visited, mp)) {
                return edge;
            }
        }
        return new int[0];
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
