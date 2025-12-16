package DataStructure.BinaryTree;


public class PathBetweenTwoNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        String s = getDirectionsOptimal(root,3,5);
        System.out.println(s);
    }

    public static String getDirectionsOptimal(TreeNode root, int startValue, int destValue){
        StringBuilder sv  = new StringBuilder();
        StringBuilder dv = new StringBuilder();

        findPath(root,startValue,sv);
        findPath(root,destValue,dv);

        int i=0;
        while(i < sv.length() && i < dv.length() && sv.charAt(i) == dv.charAt(i))
            i++;

        StringBuilder ans = new StringBuilder();
        for(int j=i;j<sv.length();j++){
            ans.append("U");
        }
        for(int j=i;j<dv.length();j++){
            ans.append(dv.charAt(j));
        }
        return ans.toString();
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {

        //From root node get paths to startNode and endNode

        String sv = findPath(root,startValue);
        String dv = findPath(root,destValue);

        //To remove the path they have in common
        int i = 0;
        while(i < sv.length() && i < dv.length() && sv.charAt(i) == dv.charAt(i)){
            i++;
        }

        StringBuilder sb = new StringBuilder();
        //The remaining String of the sv is to made in Upper direction, doesn't matter it goes left or right
        for(int j=i;j<sv.length();j++){
            sb.append("U");
        }
        //All the remaining uncommon path is to be added to answer.
        for(int j=i;j<dv.length();j++){
            sb.append(dv.charAt(j));
        }

        return sb.toString();

    }

    /**
     * The following function finds the path from root node to a particular target node
     * @param root
     * @param target
     * @return
     */
    public String findPath(TreeNode root,int target){
        if(root == null){
            return null;
        }

        if(root.val == target){
            return "";
        }

        String left = findPath(root.left,target);
        if(left != null){
            return "L" + left;
        }

        String right = findPath(root.right,target);
        if(right != null){
            return  "R" + right;
        }

        return null;
    }

    /**
     * This method is faster compared to the above method as it uses Strings, but if we use StringBuilder it is little faster, but not as fast as
     * the following method.
     */
    public static boolean findPath(TreeNode root,int target,StringBuilder sb){
        if(root == null){
            return false;
        }

        if(root.val == target){
            return true;
        }

        sb.append("L");
        if(findPath(root.left,target,sb)){
            return true;
        }
        sb.deleteCharAt(sb.length()-1);

        sb.append("R");
        if(findPath(root.right,target,sb)){
            return true;
        }
        sb.deleteCharAt(sb.length()-1);

        return false;
    }
}
