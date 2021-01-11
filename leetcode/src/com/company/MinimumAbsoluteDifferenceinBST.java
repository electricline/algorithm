package com.company;

public class MinimumAbsoluteDifferenceinBST {


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
        // inorder : left -> self -> right 로 방문하면 순서대로 나온다.
        // BST의 특징은 노드를 기준으로 왼쪽은 작고 오른쪽은 크다.

        int min;
        int prev;
        boolean flag;
        public int getMinimumDifference(TreeNode root) {
            min = Integer.MAX_VALUE;
            inorder(root);
            return min;
        }

        public void inorder(TreeNode root){

            if(root == null) return;

            inorder(root.left);

            if(!flag){
                flag = true;
            } else {
                min = Math.min(min, root.val - prev);
            }
            prev = root.val;
            inorder(root.right);

        }
    }
}
