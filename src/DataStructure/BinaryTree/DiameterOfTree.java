package DataStructure.BinaryTree;

/**
 * Using of array for mutable object so the value of interest can be retained.
 * Same logic of the height of binary tree where left height and right height are compared for everynode and maximum among them
 * is returned so what I have to do is store the sum of left height and right height as they are this will essentially get you
 * longest path for everytime and you just happen to store the max, when everytime l+h is calculated
 */

public class DiameterOfTree {

    public static int diameter(TreeNode root){
        int[] diameter = new int[1];
        diameter(root,diameter);
        return diameter[0];
    }


    public static int diameter(TreeNode root,int[] max){
        if(root == null)
            return 0;
        int leftH = diameter(root.left,max);
        int rightH = diameter(root.right,max);

        max[0] = Math.max(max[0],leftH+ rightH);

        return 1 + Math.max(leftH,rightH);

    }

    public static void main(String[] args) {
        diameter(new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7))));
    }
}
