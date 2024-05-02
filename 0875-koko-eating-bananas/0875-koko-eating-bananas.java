class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       
       int l = 0, r = 0;
       for(int pile : piles){
           if(pile > r) r = pile;
       } 
       while(l < r){
            int mid = (r + l)/2;
            int hoursSpent = 0;

            //calculate hoursSpent 
            for(int pile : piles){
               hoursSpent += Math.ceil((double) pile/mid);
            }

            if(hoursSpent <= h){
                r = mid;
            }else{
                l = mid + 1;
           }
       }
       return r;
    }
}