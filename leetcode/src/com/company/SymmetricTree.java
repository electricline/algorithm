package com.company;

import java.util.Stack;

public class SymmetricTree {


     // Definition for a binary tree node.
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
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            Stack<TreeNode> stack = new Stack();
            stack.push(root.left);
            stack.push(root.right);
            while(!stack.isEmpty()){
                TreeNode t1 = stack.pop(); TreeNode t2 = stack.pop();
                if(t1 == null && t2 == null) continue;
                if(t1 == null || t2 == null  || t1.val != t2.val) return false;
                stack.push(t1.left);
                stack.push(t2.right);
                stack.push(t1.right);
                stack.push(t2.left);
            }
            return true;
        }
    }
}
