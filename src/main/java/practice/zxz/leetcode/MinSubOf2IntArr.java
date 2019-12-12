package practice.zxz.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 面试题
 * 求解两个长度相等数组和的最小差，可以随意交换数组元素
 *
 * @author zhangxz
 * @date 2019-12-04 19:34
 */

public class MinSubOf2IntArr {


    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(10, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        System.out.println(minSub(list1, list2));
    }

    //读入两个等长的正整数序列，随机交换两个序列的值，使得两个序列的差最小
    //思路：
    //计算两个数组的和分别为sum1, sum2，两者之差为sub = sum1 - sum2
    //假设要交换的两个值：list1的a，和list2的b
    //交换后的差为 sum1 - a + b -(sum2 -b +a) = sub-2a+2b
    //则需要满足 |sub -2a+2b| < |sub|才进行交换。
    //当然如果sub=0，则直接返回了。
    //暴力枚举所有情况，时间复杂度为O(n^2)
    static int minSub(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null || list1.size() < 1 || list2.size() < 1) {
            throw new RuntimeException("数组数据不能为空");
        }
        if (list1.size() != list2.size()) {
            throw new RuntimeException("两个数组长度必须相等");
        }
        int sum1 = 0, sum2 = 0;
        for (Integer integer : list1) {
            sum1 += integer;
        }
        for (Integer integer : list2) {
            sum2 += integer;
        }
        int sub = sum1 - sum2;
        if (sub == 0) {
            return 0;
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                Integer a = list1.get(i);
                Integer b = list2.get(j);
                int newSub = sub - 2 * a + 2 * b;
                if (newSub == 0) {
                    return 0;
                }

                if (Math.abs(newSub) < Math.abs(sub)) {
                    sub = newSub;
                    list1.set(i, b);
                    list2.set(j, a);
                }
            }
        }
        return Math.abs(sub);
    }

}
