class PrefixTree {

    Node root;
    public PrefixTree() {
        root = new Node('\0');
    }

    public void insert(String word) {
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
        return getNode(word) != null && getNode(word).end == true;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    public Node getNode(String seg){
        Node curr = root;
        for(int i= 0; i < seg.length(); i++){
            char j = seg.charAt(i);
            if(curr.children[j - 'a'] == null){
                return null;
            }
            curr = curr.children[j - 'a'];
        }
        return curr;
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
