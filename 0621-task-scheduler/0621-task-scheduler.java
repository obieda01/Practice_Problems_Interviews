class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        int[] freq = new int[26];
        Queue<Pair<Integer, Integer>> availableForIdel = new LinkedList<>();
        PriorityQueue<Integer> maxHeapFreq = new PriorityQueue<>((a, b) -> b - a);

        for(char c : tasks){
            freq[c - 'A']++;
        }
        for(int freqValue: freq){
            if(freqValue > 0) maxHeapFreq.add(freqValue);
        }
        int time = 0;
        while(!maxHeapFreq.isEmpty() || !availableForIdel.isEmpty()){
            time++;
            if(!maxHeapFreq.isEmpty()){
                int freqValue = maxHeapFreq.poll();
                freqValue--;
                if(freqValue >0) availableForIdel.add(new Pair(freqValue, time + n));
            }
            if(!availableForIdel.isEmpty() && availableForIdel.peek().getValue() == time){
                maxHeapFreq.add(availableForIdel.poll().getKey());
            }
        }
        return time;

    }
}