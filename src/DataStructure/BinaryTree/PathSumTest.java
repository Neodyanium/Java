package DataStructure.BinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PathSumTest {

    TreeNode tree;

    @Test
    void pathSumNegativeSingleNode() {
        tree = new TreeNode(-3);
        assertEquals(-3,PathSum.pathSum(tree));
    }

    @Test
    void pathSumNegativeAvoidance(){
        tree = new TreeNode(2,null,new TreeNode(-5));
        assertEquals(2,PathSum.pathSum(tree));

        tree = new TreeNode(5,new TreeNode(1),new TreeNode(-10));
        assertEquals(6,PathSum.pathSum(tree));
    }
}