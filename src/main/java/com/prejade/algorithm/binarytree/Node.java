package com.prejade.algorithm.binarytree;

/**
 * 基础二叉树节点类
 * 包含值 key
 * 左节点 left
 * 右节点 right
 */
public class Node {
    private int key;
    private Node left;
    private Node right;
    private Node parent;

    public Node() {
    }

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
