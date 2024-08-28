package week1;

import utils.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(3));
        root = invertTree(root);
        System.out.println("Hello");
    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null) return null;
        TreeNode tmp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmp);
        return root;
    }
}
