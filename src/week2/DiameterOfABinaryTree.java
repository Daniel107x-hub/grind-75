package week2;
import utils.TreeNode;

public class DiameterOfABinaryTree {
    static int maxDiameter = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        diameterOfABinaryTreeHeight(root);
        System.out.println(maxDiameter);
    }

    public static int diameterOfABinaryTreeHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = diameterOfABinaryTreeHeight(root.left);
        int rightHeight = diameterOfABinaryTreeHeight(root.right);
        if(leftHeight + rightHeight > maxDiameter) maxDiameter = leftHeight + rightHeight;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
