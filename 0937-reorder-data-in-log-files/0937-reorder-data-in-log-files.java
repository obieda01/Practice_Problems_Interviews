class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<>(){
            @Override
            public int compare(String l1, String l2){
                //saparate identifier from content for esvh log
                String[] l1Split = l1.split(" ", 2);
                String[] l2Split = l2.split(" ", 2);
                boolean isdigit1 = Character.isDigit(l1Split[1].charAt(0));
                boolean isdigit2 = Character.isDigit(l2Split[1].charAt(0));
                //case both not digits
                if(!isdigit1 && !isdigit2){
                   int c = l1Split[1].compareTo(l2Split[1]);
                   //if the strings are not the same
                   if(c != 0) return c;
                   //if the strings are the same so we compare the identifier
                   return l1Split[0].compareTo(l2Split[0]);
                }else if(isdigit1 && !isdigit2){
                    return 1;
                }else if(!isdigit1 && isdigit2){
                    return -1;
                }else{
                    return 0;
                }
            }
        };
        Arrays.sort(logs, comp);
        return logs;
    }
}