package com.company;

public class KthSmallestElementinaBST {

    // Definition for a binary tree node.
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


        class Solution {
            int res = 0;
            int num = 0;
            public int kthSmallest(TreeNode root, int k) {
                inorder(root, k);
                return res;
            }

            private void inorder(TreeNode root, int k) {
                if(root.left != null)
                    inorder(root.left, k);
                num++;
                if(num == k) res = root.val;
                if(root.right != null)
                    inorder(root.right, k);
            }
        }

    }
}
