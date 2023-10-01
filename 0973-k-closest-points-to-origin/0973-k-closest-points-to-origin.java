class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(
                a[1]*a[1] + a[0]*a[0],
                b[1] *b[1] + b[0]*b[0]
            )
        );
        for(int[] point : points){
                pq.offer(point);
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] curr = pq.poll();
            res[i][0] = curr[0];
            res[i][1] = curr[1];
        }
        return res;

    }
}