/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> seen = new HashMap<>();
        return dfs(seen, node);
    }

    public Node dfs(Map<Node, Node> seen, Node node){
        if(node == null){
            return null;
        }

        if(seen.containsKey(node)){
            return seen.get(node);
        }

        Node copy = new Node(node.val);
        seen.put(node, copy);

        for(Node i : node.neighbors){
            copy.neighbors.add(dfs(seen, i));
        }

        return copy;
    }
}






