package com.leetcode.practice.BST;

public class MinAbsoluteDiffInBST {

        int res = Integer.MAX_VALUE;
        public static void main(String[] args) {

            TreeNode root   =   new TreeNode(236);
            root.left       =   new TreeNode(104);
            root.right      =   new TreeNode(701);
            root.left.right =   new TreeNode(227);
            root.right.right =  new TreeNode(911);


            MinAbsoluteDiffInBST validateBST = new MinAbsoluteDiffInBST();
            System.out.println(validateBST.MinAbsoluteDiffInBST(root));
        }

        public int MinAbsoluteDiffInBST(TreeNode root) {
            MinAbsoluteDiff(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.println(res);
            return res;
        }

        public void MinAbsoluteDiff(TreeNode root, int minValue, int maxValue) {
            if(root == null){
                return;
            }
            /*if( (root.val >= maxValue) || (root.val <= minValue)){
                res =  false;
                return;
            }*/
            res = Math.min(res,Math.min(Math.abs(root.val - maxValue), Math.abs(root.val-minValue)));

            MinAbsoluteDiff(root.left, Integer.MIN_VALUE, root.val);
            MinAbsoluteDiff(root.right, root.val, Integer.MAX_VALUE);

        }


}
