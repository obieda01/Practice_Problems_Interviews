class Solution {
    public int maxProfit(int[] prices) {
        int minV = Integer.MAX_VALUE;
        int maxSoFar = 0;
        int maxP = 0;
        for(int price : prices){
            minV = Math.min(minV, price);
            maxSoFar = price - minV;
            if(maxP < maxSoFar) maxP = maxSoFar;
        }
        return maxP;
    }
}