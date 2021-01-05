package com.company;

public class HouseRobberIII {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public int rob(TreeNode root) {
            return DFS(root)[1];
        }

        private int[] DFS(TreeNode root) {
            int[] res = new int[2];
            if(root == null) return res;
            int[] l = DFS(root.left);
            int[] r = DFS(root.right);
            res[0] = l[1] + r[1]; // root node not rob
            res[1] = Math.max(res[0], l[0] + r[0] + root.val); // root node rob
            return res;
        }
    }

}
