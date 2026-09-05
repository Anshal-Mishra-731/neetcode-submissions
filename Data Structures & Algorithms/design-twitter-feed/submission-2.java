class Twitter {

    HashMap<Integer, List<Integer>> fmp;
    HashMap<Integer, List<Pair<Integer, Integer>>> pmp;
    int count = 0;

    public Twitter() {
        fmp = new HashMap<>();
        pmp = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!pmp.containsKey(userId)){
            pmp.put(userId, new ArrayList<>());
        }
        pmp.get(userId).add(new Pair(count++, tweetId));

    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!fmp.containsKey(userId)) {
            fmp.put(userId, new ArrayList<>());
            fmp.get(userId).add(userId);
        }
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        for(int i : fmp.get(userId)){
            if(pmp.containsKey(i)){
            for(Pair<Integer, Integer> j : pmp.get(i)){
                pq.offer(j);
                if(pq.size() > 10){pq.poll();}
            }}
        }

        while(!pq.isEmpty()){
            res.add(pq.poll().getValue());
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!fmp.containsKey(followerId)){
            fmp.put(followerId, new ArrayList<>());
            fmp.get(followerId).add(followerId);
        }
        if (!fmp.get(followerId).contains(followeeId)) {
            fmp.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(fmp.containsKey(followerId)){
            fmp.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}
