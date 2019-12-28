package practice.zxz.leetcode.arrays;

/**
 * 删除元素
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-22 19:18
 */

public class RemoveElement {

    public static void main(String[] args) {

    }

    //思路：两个指针：一慢：i，从0开始，一快：j，也从0开始。
    //遍历，当值nums[j]等于val时，j都自增，i不变；如果不等，则用nums[j]代替nums[i]，然后i和j皆自增
    //时间复杂度：O(n)
    static int mySolution1(int[] nums, int val) {
        //这里有个优化点，即j的作用域可以缩小到循环体里面
        int i = 0, j = 0;
        while (j <= nums.length - 1) {
            if (nums[j] == val) {
                j++;
                continue;
            }
            nums[i++] = nums[j++];
        }
        return i;
    }

}
