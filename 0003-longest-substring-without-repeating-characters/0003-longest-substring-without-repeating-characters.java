class Solution {
    public int lengthOfLongestSubstring(String s) {
        //1. set of non repating chars
        Set<Character> set = new HashSet<>();

        //2. use max variable to keep track the max non repating chars
        int max = 0;
        
        //3. loop all chars in string and use sliding windows and check set if contain char
        int i = 0, j = 0;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);

            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
        
    }
}