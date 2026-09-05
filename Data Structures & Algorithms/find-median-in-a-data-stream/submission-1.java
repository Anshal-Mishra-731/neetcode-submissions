class MedianFinder {

    PriorityQueue<Integer> lpq;
    PriorityQueue<Integer> upq;
    int idx;
    public MedianFinder() {
        lpq = new PriorityQueue<>(Collections.reverseOrder());
        upq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lpq.offer(num);

        if (!upq.isEmpty() && lpq.peek() > upq.peek()) {
            upq.offer(lpq.poll());
        }

        if (lpq.size() - upq.size() > 1) {
            upq.offer(lpq.poll());
        }

        if (upq.size() - lpq.size() > 1) {
            lpq.offer(upq.poll());
        }


    }
    
    public double findMedian() {
        if(lpq.size() == upq.size()){
            return (double)(lpq.peek() + upq.peek()) / 2;
        }
        else{
            if(lpq.size() > upq.size()){
                return lpq.peek();
            }
            else{
                return upq.peek();
            }
        }
    }
}
