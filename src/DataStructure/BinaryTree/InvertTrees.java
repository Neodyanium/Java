package DataStructure.BinaryTree;

public class InvertTrees {

    static public TreeNode  invert(TreeNode root){
        if(root != null){
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            invert(root.left);
            invert(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        invert(new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7))));
    }
}
