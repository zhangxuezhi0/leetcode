package practice.zxz.leetcode.dynamic.planning;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * 买卖股票的最佳时机
 * <p>
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-06 11:13
 */

public class MaxProfit {

    static MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

    public static void main(String[] args) {

        int[] nums = new int[]{7, 1, 5, 3, 6, 4, 9, 8, 10, 9, 0, 11, 12, 13, 11, 11, 13};
        System.out.println(mySolution1(nums));
    }

    //动态规划
    //时间复杂度：O(n)，空间复杂度：O(1)
    static int mySolution1(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        //最小值
        int min = prices[0];
        //最大差值
        int maxSub = 0;
        for (int i = 1; i < prices.length; i++) {
            //此处可优化，先进行最小值的判断，如果符合，则根本不需要执行最大利润的重新计算了。
//            maxSub = Math.max(maxSub, prices[i] - min);
//            min = Math.min(min, prices[i]);

            if(prices[i]<=min){
                min = prices[i];
            }else{
                maxSub = Math.max(maxSub, prices[i] - min);
            }
        }
        return maxSub;
    }

}
