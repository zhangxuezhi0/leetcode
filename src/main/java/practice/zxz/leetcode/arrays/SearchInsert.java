package practice.zxz.leetcode.arrays;

/**
 * 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-22 20:15
 */

public class SearchInsert {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(mySolution3(nums, 5));
    }

    //二分查找
    static int mySolution1(int[] nums, int target) {
        return mySolution1a(nums, 0, nums.length - 1, target);
    }

    //递归解法
    //时间复杂度：O(logn)，空间复杂度：O(logn)
    static int mySolution1a(int[] nums, int left, int right, int target) {
        if (left >= right) {
            if (target > nums[left]) {
                return left + 1;
            } else {
                return left;
            }
        }
        int middle = (right + left) >> 1;
        if (nums[middle] == target) {
            return middle;
        } else if (target < nums[middle]) {
            return mySolution1a(nums, left, middle - 1, target);
        } else {
            return mySolution1a(nums, middle + 1, right, target);
        }
    }

    //迭代解法
    //时间复杂度：O(logn)，空间复杂度：O(1)
    static int mySolution2(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
//            int middle = (right + left) >> 1;
            //避免溢出
            int middle = left + (right - left) >>> 1;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (target < nums[left]) {
            return left;
        } else {
            return left + 1;
        }
    }

    static int mySolution3(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            //这里要注意，右移运算的优先级低于加减，所以必须加上括号
            int middle = left + ((right - left) >>> 1);
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

}
