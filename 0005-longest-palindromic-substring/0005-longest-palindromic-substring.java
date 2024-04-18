class Solution {
    public String longestPalindrome(String s) {
        int start = 0, last = 0;
        for(int i = 0; i < s.length(); i++){
            int evenLen = expandCenter(i, i, s);
            int oddLen = expandCenter(i, i + 1, s);
            int maxLen = Math.max(evenLen, oddLen);
            if(maxLen > (last - start)){
                start = i -( (maxLen - 1)/2);
                last = i + (maxLen/2);
            }

        }
        return s.substring(start, last + 1);
       
    }
    public int expandCenter(int i, int j, String s){
        if(i > j) return 0;
        while(i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))){
            i--;
            j++;
        }
        return j - i - 1;
    }
}