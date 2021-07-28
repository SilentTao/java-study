package com.tree;

/**
 * @author liutao
 * Date 2021/6/18 3:57 下午
 * Description:
 * Version: 1.0
 **/
public class TreeNode {

    /**
     * 下标
     */
    private int index;
    /**
     * 数值
     */
    private int data;

    private TreeNode rightNode;
    private TreeNode leftNode;

    public TreeNode() {

    }

    public   TreeNode(int index, int data, TreeNode rightNode, TreeNode leftNode) {
        index = index;
        data = data;
        rightNode = rightNode;
        leftNode = leftNode;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }
}
