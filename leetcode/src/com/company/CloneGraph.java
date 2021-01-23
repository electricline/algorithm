package com.company;

import java.util.*;

public class CloneGraph {

    // Definition for a Node.
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


    class Solution {
        public Node cloneGraph(Node node) {

            Node newNode = new Node(node.val);
            HashMap<Integer, Node> map = new HashMap<>();
            map.put(newNode.val, newNode);

            Queue<Node> q = new LinkedList<>();
            q.add(node);

            while(!q.isEmpty()){

                Node cur = q.poll();

                for(Node neighbor : cur.neighbors){
                    if(!map.containsKey(neighbor.val)){
                        map.put(neighbor.val, new Node(neighbor.val));
                        q.add(neighbor);
                    }

                    map.get(cur.val).neighbors.add(map.get(neighbor.val));
                }
            }

            return newNode;
        }
    }

}
