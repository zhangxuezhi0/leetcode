package practice.zxz.leetcode.heap;

import java.util.Arrays;

/**
 * 第k大的元素
 *
 * @author zhangxz
 * @date 2019-12-14 12:50
 */


public class KthLargestUsingArr {

    private int[] nums;
    private int k;

    public KthLargestUsingArr(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        Arrays.sort(this.nums);

    }

    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int add(int val) {
        int insertIndex = findIndex(val);
        int[] newNums = new int[nums.length + 1];

        //该过程可以简化为最后一个条件，因为他包含了前面两种特殊的情况
        /*if (insertIndex >= nums.length) {
            //插入位置在末端
            System.arraycopy(nums, 0, newNums, 0, nums.length);
        } else if (insertIndex <= 0) {
            //插入位置在开端
            System.arraycopy(nums, 0, newNums, 1, nums.length);
        } else {
            //插入位置在中间
            System.arraycopy(nums, 0, newNums, 0, insertIndex);
            System.arraycopy(nums, insertIndex, newNums, insertIndex + 1, nums.length - insertIndex);
        }*/

        System.arraycopy(nums, 0, newNums, 0, insertIndex);
        System.arraycopy(nums, insertIndex, newNums, insertIndex + 1, nums.length - insertIndex);
        newNums[insertIndex] = val;

        this.nums = newNums;
        return this.nums[this.nums.length - k];
    }

    int findIndex(int val) {
        return findIndex(val, 0, nums.length - 1);
    }

    //查找val应该插入的位置
    //时间复杂度：O(log(n))
    //空间复杂度：O(log(n))
    public int findIndex(int val, int left, int right) {
        //注意考虑空数组的情况
        if (nums.length <= 0) {
            return 0;
        }
        if (val >= nums[nums.length - 1]) {
            return nums.length;
        }
        if (val <= nums[0]) {
            return 0;
        }
        if (left >= right) {
            return left;
        }
        int mid = (right + left) / 2;
        if (val < nums[mid]) {
            return findIndex(val, left, mid);
        } else if (val > nums[mid]) {
            return findIndex(val, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int k = 4;
        int[] nums = new int[]{10, 1, 3, 5, 3, 20};
        KthLargestUsingArr kthLargest = new KthLargestUsingArr(k, nums);

        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(21));
        System.out.println(kthLargest.add(6));
        System.out.println(kthLargest.add(1));
        System.out.println("=====");
        System.out.println(kthLargest.add(20));
    }
}
