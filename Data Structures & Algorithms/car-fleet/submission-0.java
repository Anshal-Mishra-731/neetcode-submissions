class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < position.length; i++){
            mp.put(position[i], speed[i]);
        }
        List<Map.Entry<Integer, Integer>> lis = new ArrayList<>(mp.entrySet());

        lis.sort((a, b) -> b.getKey() - a.getKey());
        int res = 0;
        double lsbig = 0;
        for(int i = 0; i < lis.size(); i++){
            double num = (double)(target - lis.get(i).getKey())/ lis.get(i).getValue();

            if(num > lsbig){
                res++;
                lsbig = num;
            }
        }

        return res;
    }
}