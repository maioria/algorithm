package com.prejade.algorithm.binarytree;

/**
 * 基础二叉树
 */
public class BinaryTree {
    private Node root;

    /**
     * 中序遍历算法
     */
    public static void inorderTreeWalk(Node n) {
        if (n != null) {
            inorderTreeWalk(n.getLeft());
            System.out.println(n.getKey());
            inorderTreeWalk(n.getRight());
        }
    }

    /**
     * 查找具有关键字的结点
     * 如果key比当前结点值小则从左结点找，大则从右结点找
     * 运行时间O(h)
     *
     * @param n 如果结点为null则直接返回null
     */
    public static Node treeSearch(Node n, int key) {
        if (n == null || key == n.getKey()) {
            return n;
        }
        if (key < n.getKey()) {
            return treeSearch(n.getLeft(), key);
        } else {
            return treeSearch(n.getRight(), key);
        }
    }

    /**
     * 查找具有关键字的结点
     * 通过迭代来提升效率
     */
    public static Node iterativeTreeSearch(Node n, int key) {
        while (n != null && key == n.getKey()) {
            if (key < n.getKey()) {
                n = n.getLeft();
            } else {
                n = n.getRight();
            }
        }
        return n;
    }

    /**
     * 从树根开始查找出最小值
     */
    public static Node treeMinimum(Node n) {
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }

    /**
     * 从树根开始找出最大值
     */
    public static Node treeMaximum(Node n) {
        while (n.getRight() != null) {
            n = n.getRight();
        }
        return n;
    }

    /**
     * 插入
     */
    public static void treeInsert(BinaryTree tree, Node z) {
        Node y = null;
        Node x = tree.getRoot();
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == null) {
            tree.setRoot(z);
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }

    /**
     * 删除节点
     * 如果节点下没有右结点或者左结点，把下面结点相应上移就可以了
     * 如果存在结点，则需要找到相应结点y，右边最小结点
     */
    public static void treeDelete(BinaryTree tree, Node z) {
        if (z.getLeft() == null) {
            transplant(tree, z, z.getRight());
        } else if (z.getRight() == null) {
            transplant(tree, z, z.getLeft());
        } else {
            Node y = treeMinimum(z.getRight());
            if (y.getParent() != z) {
                transplant(tree, y, y.getRight());
                y.getRight().setParent(y);
            }
            transplant(tree, z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
        }
    }

    /**
     * 移动节点
     */
    public static void transplant(BinaryTree tree, Node u, Node v) {
        if (u.getParent() == null) {
            tree.setRoot(v);
        } else if (u.equals(u.getParent().getLeft())) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}
