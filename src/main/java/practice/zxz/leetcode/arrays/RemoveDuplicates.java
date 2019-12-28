package practice.zxz.leetcode.arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * 2019/10/23
 */


public class RemoveDuplicates {

    /**
     * 1. 保存数组有效数据长度为len，外层循环，从左往右遍历数组，遍历边界条件为len-2；再嵌套一层内循环，一外一内，而内层指针等于外层指针+1，
     * 2. 两个指针对应的值进行比较，如果相等，删除内层指针对应的值（删除方式：通过把内层指针右边的所有值，全部往左边移动一位；删除操作之后，内层指针此时指向的值已经是原数组下一个位置的值），并且len-1，
     * 内外层指针均不变。重复该步骤，直到两个指针的值不相等，或者内层指针已经超出len-1
     * 3. 外层指针往右移一位，内层指针重置为外层指针的下一个，重复步骤2，直到外层指针遍历到达边界，才结束
     *
     * @param nums 目标数组
     * @return int 数组的新长度（其实该值是数组有效数据的长度，从存储角度来看，数组长度是不变的）
     * @author Zxz
     * @date 2019/10/23 11:46
     **/
    public static int mySolution(int[] nums) {
        long currentTimeMillis = System.currentTimeMillis();
        //该算法计算的次数
        int counts = 0;

        int len = nums.length;

        //循环边界条件：len-2，len在内部会随着重复元素的删除而不断的递减，因此边界条件也随着缩小，
        for (int i = 0; i <= len - 2; i++) {
            int j = i + 1;

            while (nums[i] == nums[j]) {
                removeFromArr(nums, j);
                len--;

                counts++;

                //注意这里要加上这个跳出循环的条件，否则当最后两个数值相等时，会陷入死循环
                if (j > len - 1) {
                    break;
                }
            }
        }
        System.out.println(counts);
        System.out.println("mySolution算法耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        return len;
    }

    public static int removeFromArr(int[] ints, int i) {
        if (i > ints.length - 1) {
            //索引下标越界
            return ints.length;
        } else if (i == ints.length - 1) {
            //索引下标等于数组长度-1
            return ints.length - 1;
        }

        //手动复制数组可以用系统函数代替：System.arraycopy
        /*for (int j = i + 1; j < ints.length; j++) {
            ints[j - 1] = ints[j];
        }*/

        //以下式子中的最后一个参数的计算方式：(ints.length-1) - (i+1) + 1
        System.arraycopy(ints, i + 1, ints, i, ints.length - i - 1);
        return ints.length - 1;
    }

    /**
     * 官方题解：双指针法
     * <p>
     * 数组完成排序后，我们可以放置两个指针i 和j，其中i 是慢指针，而j 是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
     * 当我们遇到 nums[j] != nums[i]，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(n)，假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
     * 空间复杂度：O(1)
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums 目标数组
     * @return int
     * @author Zxz
     * @date 2019/10/23 19:21
     **/
    public static int removeDuplicates(int[] nums) {
        long currentTimeMillis = System.currentTimeMillis();
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println("removeDuplicates算法耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        return i + 1;
    }


    public static void main(String[] args) {
//        int[] ints = {1, 2, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 8, 8, 9, 10, 11};
        int counts = 200000;
        int[] ints = new int[counts];
        for (int i = 0; i < counts; i++) {
            ints[i] = 1234567890;
        }

        int i = mySolution(ints);
//        int i = removeDuplicates(ints);
        for (int j = 0; j < i; j++) {
            System.out.println(ints[j]);
        }
        /*int i = removeDuplicates(ints);
        for (int j = 0; j < i; j++) {
            System.out.println(ints[j]);
        }*/

    }

}
