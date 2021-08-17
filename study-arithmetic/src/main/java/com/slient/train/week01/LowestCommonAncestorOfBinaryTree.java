package com.slient.train.week01;

/**
 * @author liutao
 * Date 2021/8/17 10:49 上午
 * Description:
 * 二叉树的公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Version: 1.0
 **/
public class LowestCommonAncestorOfBinaryTree {


    /**
     *  通过记录字数父节点来进行判断是否存在父节点, 每次递归返回父节点
     *
     */
    public class SolutionTow {

        //  通过判断左右子数是否存在节点判断
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left==null&&right==null) {
                return null;

            }
            if(left==null) {
                return right;
            }
            if(right==null){
                return left;
            }
            return  root;
        }


    }


    public class SolutionOne {

        TreeNode fatherNode;

        // 循环判断
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            find(root, p, q);

            return fatherNode;
        }


        public boolean find(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            Boolean left = find(root.left, p, q);
            Boolean right = find(root.right, p, q);
            /**
             * 两种情况是找到了父亲节点
             * 1. left, right 都为真的情况下
             * 2. 但前节点和p, q相等, 且 left, right  中有一个是找到了的
             */
            if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
                fatherNode = root;
            }
            return root.val == p.val || root.val == q.val || left || right;
        }


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
