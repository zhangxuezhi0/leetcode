package practice.zxz.leetcode.dynamic.planning;

/**
 * 最大子序和
 * <p>
 * 题目描述
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-04 11:21
 */

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(mySolution2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(mySolution2(new int[]{3, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 思路：
     * 从左往右遍历数组，遍历到的位置假设为i，对应数值为nums[i]，遍历过程中保留两个数据：
     *     左最大子序和lm：代表i（包含i）左边这个序列，其最大子序和
     *     左邻最大子序和lam：代表i（包含i）左边这个序列，计算了nums[i]在内的最大子序和；保留这个值是为了在往右遍历时，可以以其为依据计算新序列的最大子序和
     * 首先，取第1个值为lm和lam
     * 然后往右推移，这时候左序列增加了一个元素，为了保证lam的最大值，作如下判断：
     * 如果lam为非正数，则使用当前遍历位置的元素代替lam原值
     *     上面的步骤需要也确实同时满足两个条件：lam值要与遍历到的位置i相邻（包括i），在前面一个条件下要满足lam是最大的
     *     也可以这样理解：i左边的最大子序和与位置i的元素nums[i]相加后，是否比nums[i]大，是则加入，否则抛弃
     * 最后，判断lm和lam的大小关系，如果新的lam值大于lm，则用lam替换lm的原值，否则lm不变（这样lm就保存了左最大子序和）
     *
     * 空间复杂度：O(1)
     * 时间复杂度：O(n)
     *
     */
    static int mySolution1(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new RuntimeException("数组不能为空！");
        }
        //左最大子序和
        int leftMax = nums[0];
        //左邻最大子序和：与当前值相邻的左最大子序和
        int leftAdjacentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (leftAdjacentMax > 0) {
                //左邻最大子序和为整数，则加入当前值
                leftAdjacentMax += nums[i];
            } else {
                //左邻最大子序和为非正数，则抛弃，用当前值代替他
                leftAdjacentMax = nums[i];
            }
            if (leftMax < leftAdjacentMax) {
                leftMax = leftAdjacentMax;
            }
        }

        return leftMax;
    }

    //暴力解法：列举所有情况，获取其中最大值
    //空间复杂度：O(1)
    //时间复杂度：O(n^2)
    static int mySolution2(int[] nums){
        if(nums==null || nums.length<1){
            throw new RuntimeException("数组不能为空");
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum>max){
                    max = sum;
                }
            }
        }
        return max;
    }

}
