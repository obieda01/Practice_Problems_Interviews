class Trie {
    
    private Node root;

    public Trie() {
        this.root = new Node('\0');    
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char x: word.toCharArray()){
            if(curr.children[x - 'a'] == null){
                curr.children[x - 'a'] = new Node(x);
            }
            curr = curr.children[x - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char x : word.toCharArray()){
            if(curr.children[x-'a'] == null) return false;
            curr = curr.children[x - 'a'];
        }
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char x : prefix.toCharArray()){
            if(curr.children[x-'a'] == null) return false;
            curr = curr.children[x - 'a'];
        }
        return true;
    }
    class Node{
        private char val;
        private boolean isWord;
        Node[] children;
        Node(char c){
            this.val = c;
            this.isWord = false;
            this.children = new Node[26];
        }
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */