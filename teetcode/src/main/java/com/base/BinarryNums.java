package com.base;

/**
 * @author liutao
 * Date 2021/6/21 6:45 下午
 * Description:
 * Version: 1.0
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 **/
public class BinarryNums {


    public static void main(StringTest[] args) throws InterruptedException {
        int[] aaa=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(aaa));
    }


    public static int trap(int[] height) throws InterruptedException {
        if(height.length<3){
            return 0;
        }
        int count=0;
        int temp=0;
        //找出最后一个最高峰
        int lastMaxPoint=0;
        for(int i=1;i<height.length;i++){
            if(height[i]>=height[lastMaxPoint]){
                lastMaxPoint=i;
            }
        }

        //初始化最左数据;
        int left=0;
        for(int i=1;i<height.length;i++){
            int nowNumber=height[i];
            if(height[left]>nowNumber){
                temp=temp+nowNumber;
            }else {
                int addWater=height[left]*(i-left-1)-temp;
                temp=0;
                count=count+addWater;
                if(i==lastMaxPoint) {
                    left=i+1;
                    i++;
                }else {
                    left=i;

                }
            }
        }
        return count;
    }


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hashPath(root, targetSum, 0);
    }

    private boolean hashPath(TreeNode root,int trageSum,int nowSum){
        //进行剪枝
        if((root==null&&nowSum!=trageSum)||(nowSum>trageSum)){
            return false;
        }

        int leftNowSum=nowSum+root.val;
        if(nowSum==leftNowSum){
            return true;
        }
        boolean leftSuccess=hashPath(root.left,trageSum,leftNowSum);
        boolean rightSuccess=hashPath(root.right,trageSum,leftNowSum);

        return leftSuccess==true||rightSuccess==true;

    }

}
