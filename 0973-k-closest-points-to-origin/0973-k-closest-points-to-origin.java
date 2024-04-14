class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[] distances = new int[points.length];
        for(int i = 0; i < points.length; i++){
            distances[i] = calDis(points[i]);
        }
        //[1, 5, 3]
        Arrays.sort(distances);
        //[1, 3, 5]
        int distK = distances[k - 1];
        int[][] distancesK = new int[k][2];
        int index = 0;
        for(int i = 0; i < points.length; i++){
            if(calDis(points[i]) <= distK){
                distancesK[index++] = points[i];
            }
        }
        return distancesK;
    }
    public int calDis(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}