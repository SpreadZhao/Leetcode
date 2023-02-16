package questions;


import model.TreeNode;

/**
 * Link: <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of Binary Tree</a>
 */
public class MaxDepthOfBinaryTree {


    // Oh no..
    private int len = 0;
    private boolean leftNull = false;
    private boolean rightNull = false;
    public int maxDepth(TreeNode root) {
        //int len = 0;
        if(root == null) return len;
        //if() len++;
        if(root.left != null){
            leftNull = false;
            maxDepth(root.left);
        }else leftNull = true;
        if(root.right != null){
            rightNull = false;
            maxDepth(root.right);
        }else rightNull = true;
        return len;
    }

    public int maxDepth2(TreeNode root) {
        int max=0;//存储子树的深度
        int leftMax=0;
        int rightMax=0;
        if (root != null) {//如果当前子树不为空,非空树
            max++;//深度加1
            leftMax = maxDepth2(root.left);//左子树深度
            rightMax = maxDepth2(root.right);//右子树深度
            max += Math.max(leftMax, rightMax);//当前子树的深度
        }
        return max;//返回当前子树的深度
    }
}
