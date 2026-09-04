class Solution {
    public double dist(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, int[]>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        for(int[] i : points){
            pq.offer(new Pair<>(dist(i), i));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int idx = 0;
        while(!pq.isEmpty()){
            result[idx++] = (pq.poll().getValue());
        }
        return result;
    }
}
