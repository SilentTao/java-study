package card.week01;

/**
 * @author liutao
 * Date 2021/8/6 1:07 下午
 * Description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * Version: 1.0
 **/
public class MoveZero_287 {

    public void moveZeroes(int[] nums) {
        //临时记录值
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex++;
            } else {
                nums[i - zeroIndex] = nums[i];
                //处理腾出的位子
                if (zeroIndex > 0) {
                    nums[i] = 0;
                }
            }
        }


    }


}
