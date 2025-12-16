package DataStructure.BinaryTree;

/***
 * Use the similar recursion logic used for height or diameter(longest path)
 * store each of the in the maxi variable where each maxi = lh + node.val + rh
 * here what do you return in max path sum with respect to the previous root, so it's root.val + max(lh,rh)
 *
 *  * Errors: 1)If you keep the array value default 0 then if the nodes had only negative values the Math.max will pick 0 and you get error values
 *  instead choose max min value
 * 2) If you have different paths and some of the nodes are negative its better to not consider them in the path sum how to achieve this
 * whenever you are going in a recursive function just make sure the you leave the negative behind use Math.max
 */

public class PathSum {

    public static int pathSum(TreeNode root){
        int[] maxPathSum = new int[1];
        //E1 resolution
        maxPathSum[0] = Integer.MIN_VALUE;
        pathSumHelper(root,maxPathSum);
        return maxPathSum[0];
    }

    public static int pathSumHelper(TreeNode node,int[] pathSum){
        if(node == null)
            return 0;
        //E2 Resolution
        int ls = Math.max(0,pathSumHelper(node.left,pathSum));
        int rs = Math.max(0,pathSumHelper(node.right,pathSum));

        pathSum[0] = Math.max(node.val + ls + rs,pathSum[0]);

        return node.val + Math.max(ls,rs);
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(-10,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(pathSum(test));
        test = new TreeNode(5,new TreeNode(1),new TreeNode(-10));
        pathSum(test);
    }
}
