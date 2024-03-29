package com.slient.train.week01;

/**
 * @author liutao
 * Date 2021/8/17 10:49 上午
 * Description:
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Version: 1.0
 **/
public class LowestCommonAncestorOfBinarySearchTree {


    /**
     * 搜索二叉树
     */
    public class SolutionOne {


        /**
         * 搜索二叉树, 特点:
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return  null;
            }
            //找到遍返回
            if(root.val==q.val||root.val==p.val){
                return  root;
            }
            //两个值都再右边的情况
            if(root.val<p.val&&root.val<q.val){
                return  lowestCommonAncestor(root.right,p,q);
            }
            // 两个节点都再左边的情况
            if(root.val>p.val&&root.val>q.val){
                return lowestCommonAncestor(root.left,p,q);
            }
            // 如果在两边的话, 直接返回root节点
            return root;
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
}
