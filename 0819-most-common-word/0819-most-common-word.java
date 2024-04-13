class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String ans = "";
        int max = 0;
        //a set for the banned words to reduce lookup time to O(1)
        Set<String> bannedSet = new HashSet<>();
        for(String bannedString : banned){
            bannedSet.add(bannedString);
        }

        //transform the paragraph to char[]
        char[] charArray = paragraph.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        //loop the char[] and use string builder to concatinate the words in paragraph
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArray.length; i++){
            //word is letters and stop when the character is not a letter
            if(Character.isLetter(charArray[i])){
                sb.append(Character.toLowerCase(charArray[i]));
                if (i != charArray.length - 1)
                    // skip the rest of the processing
                    continue;
            }
                if (sb.length() > 0) {

                    if(!bannedSet.contains(sb.toString())){
                        int currentWordFreq = map.getOrDefault(sb.toString(), 0) + 1;
                        map.put(sb.toString(), currentWordFreq);
                        if(currentWordFreq > max){
                            max = currentWordFreq;
                            ans = sb.toString();
                        }
                    }
                    sb = new StringBuilder();


            }
        }
        //add the word to map with count 
        //update the max freq everytime we add the word to the map
        //return word max freq
        return ans;
    }
}