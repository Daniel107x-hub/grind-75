package week3;

import utils.Node;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node copy = cloneGraph(node1);
    }

    public static Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> nodes=  new HashMap<>();
        return deepCopy(node, nodes);
    }

    public static Node deepCopy(Node node, Map<Integer, Node> nodes){
        if(nodes.containsKey(node.val)) return nodes.get(node.val);
        Node newNode = new Node(node.val);
        nodes.put(newNode.val, newNode);
        for(Node neighbor : node.neighbors) newNode.neighbors.add(deepCopy(neighbor, nodes));
        return newNode;
    }
}
