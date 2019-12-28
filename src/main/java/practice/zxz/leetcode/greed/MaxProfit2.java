package practice.zxz.leetcode.greed;

/**
 * 买卖股票的最佳时机2
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-25 23:04
 */

public class MaxProfit2 {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int i = mySolution2(nums);
        System.out.println(i);
    }

    static int mySolution2(int[] prices) {
        return mySolution2a(prices, 0, prices.length - 1);
    }

    //边界条件：[left, right]
    //暴力法：時間複雜度：O(n^n)，
    static int mySolution2a(int[] prices, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int result = 0;

        for (int i = left; i < right; i++) {
            for (int j = 1; j <= (right - i); j++) {
                int r = (prices[i + j] - prices[i] + mySolution2a(prices, i + j + 1, right));
                if (r > result) {
                    result = r;
                }
            }
        }
        return result;
    }

    static int mySolution1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int leftMin = prices[0];
        int i = 1;
        while (i < prices.length) {
            //如果后继值比前驱值小，则交换最小值，然后跳出该次循环
            if (prices[i] < prices[i - 1]) {
                leftMin = prices[i++];
                continue;
            }
            //如果后继值比前驱值大或相等，则索引自增直到后驱值小于前驱值或者到达数组末尾
            while (i < prices.length && prices[i] >= prices[i - 1]) {
                i++;
            }
            //用当前范围内的最大后驱值减去最小前驱值，得到最大利润
            maxProfit += (prices[i - 1] - leftMin);
            //越界检查，然后用下一个区间的初始值作为下一轮循环的开始
            if (i < prices.length) {
                leftMin = prices[i];
            }
        }
        return maxProfit;
    }

}
