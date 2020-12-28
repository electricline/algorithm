package com.company;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {


    //  Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> levelOrder = new ArrayList<>();
            Map<Integer, List<Integer>> map = new TreeMap<>();
            BFS(root, map);
            getLevelOrder(map, res, levelOrder);
            return res;
        }

        private void getLevelOrder(Map<Integer, List<Integer>> map, List<List<Integer>> res, List<Integer> levelOrder) {

            for(int depth : map.keySet()){
                levelOrder = map.get(depth);
                res.add(levelOrder);
            }

        }

        private void BFS(TreeNode root, Map<Integer, List<Integer>> map) {

            Queue<pair> q = new LinkedList<>();
            q.add(new pair(root, 1));

            while(!q.isEmpty()){

                pair curr = q.poll();

                if(map.containsKey(curr.depth)){
                    List<Integer> getList = map.get(curr.depth);
                    getList.add(curr.treeNode.val);
                    map.put(curr.depth, getList);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr.treeNode.val);
                    map.put(curr.depth, list);
                }

                if(curr.treeNode.left != null)
                    q.add(new pair(curr.treeNode.left, curr.depth+1));
                if(curr.treeNode.right != null)
                    q.add(new pair(curr.treeNode.right, curr.depth+1));
            }

        }
    }

    class pair {
          TreeNode treeNode;
          int depth;

          pair(TreeNode treeNode, int depth){
              this.treeNode = treeNode;
              this.depth = depth;
          }
    }

}
