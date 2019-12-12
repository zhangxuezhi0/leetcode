package practice.zxz.leetcode.hash.table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-07 11:23
 */

public class SingleNumber {

    //使用哈希表，key为对应值，value为该值出现的次数
    static int mySolution1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }


    //同样使用哈希表，但是思路是：未出现的加入，出现了的删除，最后剩下的就是结果
    static int officialSolution1(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                hashSet.remove(num);
            } else {
                hashSet.add(num);
            }
        }
        for (Integer integer : hashSet) {
            return integer;
        }
        return -1;
    }

    //位操作，官方题解；依赖原理：两个相同的数异或之后为0，任何数和0进行异或，都等于他本身
    static int officialSolution2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
