package week3;

import utils.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        for(List<Integer> level : levelOrderSingleStack(root)){
            for(Integer element : level) System.out.print(element + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> mainStack = new Stack<>();
        Stack<TreeNode> temporary = new Stack<>();
        mainStack.add(root);
        List<Integer> level = new ArrayList<>();
        while(!mainStack.empty()){
            TreeNode current = mainStack.pop();
            level.add(current.val);
            if(current.left != null) temporary.add(current.left);
            if(current.right != null) temporary.add(current.right);
            if(mainStack.empty()){
                result.add(level);
                while(!temporary.empty()) mainStack.add(temporary.pop());
                level = new ArrayList<>();
            }
        }
        return result;
    }

    public static List<List<Integer>> levelOrderSingleStack(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int inLevel = queue.size();
            List<Integer> level = new ArrayList<>();
            while(inLevel > 0){
                TreeNode current = queue.pop();
                level.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                inLevel--;
            }
            result.add(level);
        }
        return result;
    }
}
