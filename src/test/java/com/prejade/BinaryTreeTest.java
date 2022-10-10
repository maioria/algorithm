package com.prejade;

import com.prejade.algorithm.binarytree.BinaryTree;
import com.prejade.algorithm.binarytree.Node;

import org.junit.Test;

import java.util.Random;

public class BinaryTreeTest {
    /**
     * 随机组装二叉树并进行输出
     */
    @Test
    public void inorderTreeWalkTest() {
        int maxKey = 1000;
        BinaryTree tree = new BinaryTree();
        Node root = new Node(maxKey);
        tree.setRoot(root);
        for (int i = 0; i < 100; i++) {
            BinaryTree.treeInsert(tree, new Node(getRandom(maxKey)));
        }
        BinaryTree.inorderTreeWalk(root);
        assert true;
    }

    private int getRandom(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
