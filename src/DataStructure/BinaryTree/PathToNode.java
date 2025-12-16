package DataStructure.BinaryTree;


//Path to Node from the root
public class PathToNode {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        String s = findPath(root,5);
        System.out.println(s);
    }

    public static String findPath(TreeNode root, int target) {
        // Base case: if root is null, return null indicating not found
        if (root == null) {
            return null;
        }

        // Base case: if root is the target node, return an empty string
        if (root.val == target) {
            return "";
        }

        // Search in the left subtree
        String leftPath = findPath(root.left, target);
        if (leftPath != null) {
            return "L" + leftPath;  // Found in the left subtree
        }

        // Search in the right subtree
        String rightPath = findPath(root.right, target);
        if (rightPath != null) {
            return "R" + rightPath;  // Found in the right subtree
        }

        // If not found in either subtree, return null
        return null;
    }
}
