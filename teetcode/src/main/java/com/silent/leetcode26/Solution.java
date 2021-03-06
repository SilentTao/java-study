package com.silent.leetcode26;

/**
 * Author liutao
 * Date 2020/1/25 5:09 下午
 * Description:
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 *  
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Version: 1.0
 **/
public class Solution {

    public static void main(String[] args) {
        int[] nms = {1, 2, 3, 3, 4, 4, 5, 6, 7,7,99};
        Solution solution = new Solution();
        int a=solution.removeDuplicates(nms);
        for (int i = 0; i < a; i++) {
            System.out.println(nms[i]);
        }
    }


    // 那自身和前面的序号去做比较
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int flag = 1; // 默认一个值
        for (int i = 0; i < nums.length; i++) {
            System.out.println("当前处理数字的序号是: " + i + ",当前处理的数字是: " + nums[i]);
            if (i == 0) {
                continue;
            }
            if (nums[i] != nums[flag-1]) {
                nums[flag] = nums[i];
                flag++;
            } else { // 如果当前值和下一个值相同
                nums[flag] = nums[i];
            }
        }

        return flag;

    }


}
