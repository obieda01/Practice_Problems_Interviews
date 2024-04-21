class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //calculate all distances 
        int[] distances = new int[points.length];
        for(int i = 0; i < points.length; i++){
            distances[i] = calDist(points[i]);
        }
        //sort calculated distance
        Arrays.sort(distances);
        //find the k - 1 distance to use as threshold
        int distancek = distances[k - 1];
        //keep track ans index
        int index = 0;
        //add to ans if less than k-1 distance
        int[][] ans = new int[k][2];
        for(int i = 0; i < points.length; i++){
            if(calDist(points[i]) <= distancek){
                ans[index] = points[i];
                index++;
            }
        }
        return ans;
    }
    public int calDist(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}