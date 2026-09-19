class Solution {
    int idx = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            mp.putIfAbsent(prerequisites[i][0], new ArrayList<>());
            mp.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, mp, visited, path, res)){
                return new int[0];
            }
        }

        return res;
    }

    public boolean dfs(int key, Map<Integer, List<Integer>> mp, Set<Integer> visited, Set<Integer> path, int[] res){
        if(path.contains(key)){
            return false;
        }

        if(visited.contains(key)){
            return true;
        }

        path.add(key);
        if(mp.get(key) != null){
            for(int i : mp.get(key)){
                if(!dfs(i, mp, visited, path, res)){
                    return false;
                }
            }
        }
        path.remove(key);

        res[idx++] = key;
        visited.add(key);
        return true;
    }
}
