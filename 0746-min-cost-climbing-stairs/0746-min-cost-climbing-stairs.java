class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length + 1];
        res[cost.length] = 0;
        res[cost.length - 1] = cost[cost.length - 1];
        for(int i = cost.length - 2; i >= 0; i--){
                if(res[ i + 1] < res[i + 2]){
                  res[i] = res[i + 1] + cost[i];  
                }else{
                    res[i] = res[i + 2] + cost[i];
                } 

            }
        return Math.min(res[0], res[1]);
        }
    }