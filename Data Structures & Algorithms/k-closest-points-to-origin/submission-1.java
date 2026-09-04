class Solution {
    public int dist(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(dist(b), dist(a)));
        for(int[] i : points){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int idx = 0;
        while(!pq.isEmpty()){
            result[idx++] = (pq.poll());
        }
        return result;
    }
}
