package card.week01;

/**
 * @author liutao
 * Date 2021/8/6 1:15 下午
 * Description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * Version: 1.0
 **/
public class ClimbStairs_70 {
        public int climbStairs(int n) {
            //如果小于3则都是n
            if (n < 3) {
                return n;
            }
            //前两位
            int preTow = 1;
            //前一位
            int preOne = 2;
            for (int i = 3; i <= n; i++) {
                int count = preOne + preTow;
                preTow = preOne;
                preOne = count;
            }
            return preOne;
        }
}
