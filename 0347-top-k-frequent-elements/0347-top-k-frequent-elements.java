class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> 
        a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(e);
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            if(!pq.isEmpty()){
                res[i] = pq.poll().getKey();
            }
        }
        return res;
    }
}