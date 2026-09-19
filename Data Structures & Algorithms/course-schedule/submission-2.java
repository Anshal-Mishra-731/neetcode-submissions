class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            mp.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            mp.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        Set<Integer> processed = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, mp, visited, processed)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int key, Map<Integer, List<Integer>> mp, Set<Integer> visited, Set<Integer> processed){
        if(visited.contains(key)){
            return false;
        }

        if(processed.contains(key)){
            return true;
        }

        visited.add(key);

        if(mp.get(key) != null){
            for(int i : mp.get(key)){
                if(!dfs(i, mp, visited, processed)){
                    return false;
                }
            }
        }

        visited.remove(key);
        processed.add(key);

        return true;
    }
}
