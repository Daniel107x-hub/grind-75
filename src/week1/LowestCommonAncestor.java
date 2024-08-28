package week1;

import utils.TreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode q = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        TreeNode p = new TreeNode(2, new TreeNode(0), q);
        TreeNode root = new TreeNode(6, p, new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        System.out.println(lca(root, p, q).val);
    }

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        TreeNode max = p.val > q.val ? p : q;
        TreeNode min = p.val < q.val ? p : q;
        while(true){
            if(min.val <= root.val && max.val >= root.val) return root;
            if(min.val > root.val) root = root.right;
            else root = root.left;
        }
    }
}
