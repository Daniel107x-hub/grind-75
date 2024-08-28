package week1;

import utils.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root){
        if(root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    // Second approach
    public static boolean isBalanced2(TreeNode root){
        return validateHeight(root) >= 0;
    }

    public static int validateHeight(TreeNode root){
        if(root == null) return 0;
        int left = validateHeight(root.left);
        int right = validateHeight(root.right);
        if(left < 0 || right < 0) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
