package com.leetcode.practice.BST;

public class ValidateBST {
    boolean res = true;
    public static void main(String[] args) {
        TreeNode root   =   new TreeNode(10);
        root.left       =   new TreeNode(5);
        root.right      =   new TreeNode(15);
        root.right.left =   new TreeNode(6);
        root.right.right =  new TreeNode(20);


        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return res;
    }

    public void isValid(TreeNode root, int minValue, int maxValue) {
        if(root == null){
            return;
        }
        if( (root.val >= maxValue) || (root.val <= minValue)){
            res =  false;
            return;
        }

        isValid(root.left, Integer.MIN_VALUE, root.val);
        isValid(root.right, root.val, Integer.MAX_VALUE);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}
