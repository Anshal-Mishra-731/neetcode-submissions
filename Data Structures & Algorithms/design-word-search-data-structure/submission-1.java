class WordDictionary {

    Node root;
    public WordDictionary() {
        root = new Node('\0');
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char j = word.charAt(i);
            if(curr.children[j - 'a'] == null){
                curr.children[j - 'a'] = new Node(j);
            }
            curr = curr.children[j - 'a'];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return backt(root, word, 0);
    }

    public boolean backt(Node curr, String word, int i){
        if(i == word.length()){
            return curr.end;
        }
        char j = word.charAt(i);
        if(j != '.'){
            if(curr.children[j - 'a'] == null){
                return false;
            }
            return backt(curr.children[j - 'a'], word, i + 1);
        }
        for(Node cu : curr.children){
            if(cu != null){
                if(backt(cu, word, i+1)){
                    return true;
                }
            }
        }
        return false;
    }

    class Node {
        public char c;
        public boolean end;
        public Node[] children;

        public Node(char c){
            this.c = c;
            end = false;
            children = new Node[26];
        }
    }
}
