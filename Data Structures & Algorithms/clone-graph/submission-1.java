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
    HashMap <Integer, Node> added_elements;
    public Node cloneGraph(Node node) {
        if (node==null) return null;

        added_elements = new HashMap<>();
        Node cloned_graph = recursive_cg(node, new ArrayList<>());
        
 
        return cloned_graph;
    }

    private Node recursive_cg(Node node, List<Node> neighbors_cl) {
        
        Node copy_node = new Node(node.val);
        added_elements.put(node.val,copy_node);
        for (int i=0;i<node.neighbors.size();i++) {
            Node neighbor = node.neighbors.get(i);

            if (added_elements.containsKey(neighbor.val)) {
                neighbors_cl.add(added_elements.get(neighbor.val));
            }
                
            else {
                Node cloned_node = recursive_cg(neighbor, new ArrayList<>());

                neighbors_cl.add(cloned_node);
            }
            
        }

        copy_node.neighbors=neighbors_cl;

        return copy_node;


    }
}