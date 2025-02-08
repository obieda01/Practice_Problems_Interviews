class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> s = new Stack<>();
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, s, res);
        return res;
    }
    public void backtrack(
        int o,
        int c,
        int n,
        Stack<Character> s,
        List<String> res
    ){
        if(o == c && c == n){
            Iterator it = s.iterator();
            StringBuffer bf = new StringBuffer();
            while(it.hasNext()){
                bf.append(it.next());
            }
            res.add(bf.toString());
        }
        if(o < n){
            s.add('(');
            backtrack(o + 1, c, n, s, res);
            s.pop();
        }
        if(c < o){
            s.add(')');
            backtrack(o, c + 1, n, s, res);
            s.pop();
        }
    }
}