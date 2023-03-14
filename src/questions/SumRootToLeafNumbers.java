package questions;

import model.TreeNode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = root.val;
        if(root.left == null && root.right == null) return sum;
        if(root.right == null){
            int left = sumNumbers(root.left);
            return sum * (int)Math.pow(10, getLen(left)) + left;
        }
        if(root.left == null){
            int right = sumNumbers(root.right);
            return sum * (int)Math.pow(10, getLen(right)) + right;
        }
        int left = sumNumbers(root.left);
        int right = sumNumbers(root.right);
        return sum * (int)Math.pow(10, getLen(left)) + left + sum * (int)Math.pow(10, getLen(right)) + right;
    }

    public int getLen(int n){
        int len = 0;
        while(n > 0){ // 9
            n /= 10;
            len++;
        }
        return len;
    }
}
