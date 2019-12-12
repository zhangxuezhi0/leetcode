package practice.zxz.leetcode.dynamic.planning;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-05 11:53
 */

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(mySolution2(2));
        System.out.println(mySolution2(3));
        System.out.println(mySolution2(4));
        System.out.println(mySolution2(5));
        System.out.println(mySolution2(6));

        System.out.println(mySolution1(6));
        System.out.println(mySolution2(6));
        System.out.println(mySolution3(6));
        System.out.println(officialSolution1(6));
        System.out.println(officialSolution2(6));

//        System.out.println(mySolution2(45));
//        System.out.println(mySolution1(45));
    }

    /**
     * 暴力解法，来自官方题解
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static int officialSolution1(int n) {
        return officialSolution1(0, n);
    }

    static int officialSolution1(int index, int n) {
        if (index > n) {
            return 0;
        }
        if (index == n) {
            return 1;
        }
        return officialSolution1(index + 1, n) + officialSolution1(index + 2, n);
    }

    //官方解法，相比上一种，多了一个参数：数组，来临时存储计算的结果，可以避免重复的计算，是一种以空间换时间的策略
    //时间复杂度：O(n), 空间复杂度：O(n)
    static int officialSolution2(int n) {
        int[] memo = new int[n + 1];
        return officialSolution2(0, n, memo);
    }

    static int officialSolution2(int index, int n, int[] memo) {
        if (index > n) {
            return 0;
        }
        if (index == n) {
            return 1;
        }
        if (memo[index] > 0) {
            return memo[index];
        }
        memo[index] = officialSolution2(index + 1, n, memo) + officialSolution2(index + 2, n, memo);
        return memo[index];
    }

    //使用递归
    //假设爬到n阶的方法有f(n)种，则 f(n) = f(n-1) + f(n-2)
    //时间复杂度：O(2^n), 空间复杂度：O(n)
    static int mySolution1(int n) {
        if (n <= 2) {
            return n;
        }
        return mySolution1(n - 1) + mySolution1(n - 2);
    }

    //根据官方题解，对提递归进行优化，牺牲空间换取时间
    static int mySolution3(int n) {
        int[] memo = new int[n + 1];
        return mySolution3(n, memo);
    }

    private static int mySolution3(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        //最后这两步不能合并为1步，否则数组就没有了赋值操作，就起不到数据缓存的效果
        memo[n] = mySolution3(n - 1, memo) + mySolution3(n - 2, memo);
        return memo[n];
    }


    //使用迭代
    //时间复杂度：O(n)，空间复杂度：O(1)
    static int mySolution2(int n) {
        if (n <= 2) {
            return n;
        }
        int step1 = 1;
        int step2 = 2;
        int allSteps = 0;
        while (n > 2) {
            allSteps = step1 + step2;
            step1 = step2;
            step2 = allSteps;
            n--;
        }
        return allSteps;
    }


}
