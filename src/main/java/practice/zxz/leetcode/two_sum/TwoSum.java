package practice.zxz.leetcode.two_sum;

import first.zxz.tools.PrintTool;

import java.util.HashMap;

/**
 * 两数之和 leetcode论坛，评论区最优解
 * <p>
 * 问题描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author zhangxz
 * 2019/9/29
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 6, 2, 8, 10, 99, 7, 23};
        int target1 = 3;
        int target2 = 30;
        int target3 = 180;
        int target4 = 10;
        int target5 = 1000;

        System.out.println("*** method1 start ***");
        PrintTool.printIntArr(method1(ints, target1));
        PrintTool.printIntArr(method1(ints, target2));
        PrintTool.printIntArr(method1(ints, target3));
        PrintTool.printIntArr(method1(ints, target4));
        PrintTool.printIntArr(method1(ints, target5));
        System.out.println("*** method1 end ***");

        System.out.println("*** method2 start ***");
        PrintTool.printIntArr(method2(ints, target1));
        PrintTool.printIntArr(method2(ints, target2));
        PrintTool.printIntArr(method2(ints, target3));
        PrintTool.printIntArr(method2(ints, target4));
        PrintTool.printIntArr(method2(ints, target5));
        System.out.println("*** method2 end ***");

        System.out.println("*** method3 start ***");
        PrintTool.printIntArr(method3(ints, target1));
        PrintTool.printIntArr(method3(ints, target2));
        PrintTool.printIntArr(method3(ints, target3));
        PrintTool.printIntArr(method3(ints, target4));
        PrintTool.printIntArr(method3(ints, target5));
        System.out.println("*** method3 end ***");
    }

    /**
     * 该方法是LeetCode评论区的一种较优解 ，时间复杂度为 O(n)
     *
     * @param nums   数组
     * @param target 目标值
     * @return int[]
     * @author Zxz
     * @date 2019/9/30 12:09
     **/
    private static int[] method1(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        return indexs;
    }

    /**
     * 最简单，效率最低的一种解法，时间复杂度为：O(n^2)
     *
     * @param nums   数组
     * @param target 目标值
     * @return int[]
     * @author Zxz
     * @date 2019/9/30 12:10
     **/
    private static int[] method2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 参考第一种解法，把步骤分解出来，时间复杂度同样是 O(n)
     *
     * @param nums   数组
     * @param target 目标值
     * @return int[]
     * @author Zxz
     * @date 2019/9/30 12:10
     **/
    private static int[] method3(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) != i) {
                return new int[]{i, hashMap.get(nums[i])};
            }
        }
        return new int[]{-1, -1};
    }


}
