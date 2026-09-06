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
    public Node dfs(Node node, Map<Node, Node> map){
        //check if its empty
        if(node == null){
            return null;
        }

        //check if its present
        if(map.containsKey(node)){
            return map.get(node);
        }

        //create copy of node and put in the map
        Node copy = new Node(node.val);
        map.put(node, copy);

        //Explore the other node using dfs
        for(Node neigbh : node.neighbors){
            copy.neighbors.add(dfs(neigbh, map));
        }

        //return the copy
        return copy;
    }
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }
}