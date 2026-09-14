class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie preft = new Trie();
        for(String s : words){
            preft.insert(s);
        }
        List<String> res = new ArrayList<>();
        Set<Pair<Integer, Integer>> used = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                backt(board, i, j, preft.root, used, "", res);
            }
        }
        return res;
    }

public void backt(char[][] board, int i, int j, Node parent, Set<Pair<Integer, Integer>> used, String subans, List<String>res) {
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
    if(used.contains(new Pair<>(i, j))) return;

    Node child = parent.children[board[i][j] - 'a'];
    if(child == null) return;

    subans += board[i][j];

    if(child.end){
        res.add(subans);
        child.end = false;
    }

    used.add(new Pair<>(i, j));
    backt(board, i + 1, j, child, used, subans, res);
    backt(board, i - 1, j, child, used, subans, res);
    backt(board, i, j + 1, child, used, subans, res);
    backt(board, i, j - 1, child, used, subans, res);
    used.remove(new Pair<>(i, j));
}


    class Trie {
        public Node root;
        public Trie(){
            root = new Node('\0');
        }
        public void insert(String word){
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
    }
    class Node{
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


