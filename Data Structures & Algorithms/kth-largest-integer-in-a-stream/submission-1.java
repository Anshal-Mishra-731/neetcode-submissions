class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int nm : nums){
            add1(nm);
        }
    }
    public void add1(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
