class Solution {
    int res = 0;
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i =0; i < edges.length; i++){
            mp.putIfAbsent(edges[i][0], new ArrayList<>());
            mp.putIfAbsent(edges[i][1], new ArrayList<>());

            mp.get(edges[i][0]).add(edges[i][1]);
            mp.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        for(int i =0; i < n; i++){
            if(!visited.contains(i)){
                res++;
            }
            dfs(-1, i, visited, mp);
        }
        return res;
    }

    public void dfs(int vater, int key, Set<Integer> visited, Map<Integer, List<Integer>> mp){
        if(visited.contains(key)){
            return;
        }

        visited.add(key);
        if(mp.get(key) != null){
            for(int i : mp.get(key)){
                dfs(key, i, visited, mp);
            }
        }
        return;
    }
}
