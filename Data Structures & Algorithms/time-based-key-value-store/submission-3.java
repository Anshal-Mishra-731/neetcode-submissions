class TimeMap {

    class Pair {
        String value; 
        Integer timestamp;

        Pair(String value, Integer timestamp){
            this.value = value; 
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> stamp;
    int marx = 0; 

    public TimeMap() {
        stamp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        stamp.putIfAbsent(key, new ArrayList<>()); 
        stamp.get(key).add(new Pair(value, timestamp)); 
    }
    
    public String get(String key, int timestamp) {
        if(!stamp.containsKey(key)){
            return "";
        }

        List<Pair> arr = stamp.get(key); 

        int low = 0; 
        int high = arr.size() - 1; 

        String ans = "";

        while(low <= high){
            int mid = (low + high)/2; 

            if(arr.get(mid).timestamp <= timestamp){
                ans = arr.get(mid).value; 
                low = mid + 1;
            }
            else{
                high = mid - 1; 
            }
        }
        return ans;
    }
}
