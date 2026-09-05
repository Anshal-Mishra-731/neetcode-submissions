class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char ch : tasks){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : mp.values()){
            pq.offer(i);
        }

        int addi = 0;
        int ini = pq.poll();

        while(!pq.isEmpty() && pq.peek() == ini){
            addi += 1;
            pq.poll();
        }

        return Math.max((ini-1)*(n+1) + 1 + addi, tasks.length);
    }
}
