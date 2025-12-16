package DataStructure.BinaryTree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversals {
    public static void traversals(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new Pair(root,1));
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> p = stack.pop();

            if(p.getValue() == 1){
                TreeNode node = p.getKey();
                preorder.add(node.val);
                stack.push(new Pair(node,p.getValue() + 1));
                if(node.left != null){
                    stack.push(new Pair(node.left,1));
                }
            }

            else if(p.getValue() == 2){
                TreeNode node = p.getKey();
                inorder.add(node.val);
                stack.push(new Pair<>(node,p.getValue()+1));
                if(node.right != null){
                    stack.push(new Pair(node.right,1));
                }
            }
            else{
                postorder.add(p.getKey().val);
            }
        }
        System.out.println("Preorder:"+preorder +"\nInorder:"+inorder+"\nPostorder:"+postorder);
    }


    public static void main(String[] args){
        TreeNode tree = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(4),new TreeNode(3)));
        traversals(tree);
//        traversals(new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7))));
    }

}

