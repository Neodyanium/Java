package DataStructure.BinaryTree;

/**
 * Used inorder traversal logic which is similar to what used for checking if the given two trees are same
 * Instead of passing same root like (p.left,q.left), since we wanted to check if mirror I passed opposite pair and it worked
 * I need to check Ideal solution I think it kind of repeats itself.
 */

public class MirrorTree {
    public static boolean isMirror(TreeNode root){
        if(root != null){
            return isMirror(root,root);
        }
        return false;
    }

    public static boolean isMirror(TreeNode p,TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        boolean ex = isMirror(p.left,q.right);
        boolean ex2 =  (p.val == q.val);
        boolean ex3 =  isMirror(p.right , q.left);
        return (ex && ex2 && ex3);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(4),new TreeNode(3)));
        isMirror(tree);
    }
}
