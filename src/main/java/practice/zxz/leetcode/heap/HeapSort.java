package practice.zxz.leetcode.heap;

import first.zxz.tools.ArraysTool;
import first.zxz.tools.PrintTool;

/**
 * 堆排序 使用大顶堆
 * 思路：
 * 初始化数组为大顶堆，
 * 然后把根节点和最后一个节点进行交换，自上而下调整堆，但是不需要调整交换的节点及其后面的节点
 * 调整后除了最后的那些节点，前面的节点仍然构成一个大顶堆，重复上面的步骤，直到只剩下根节点，结束。
 *
 * @author zhangxz
 * @date 2019-12-15 17:10
 */

public class HeapSort {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 6, 4, 7, 2};
        sort(nums);
        PrintTool.printIntArr(nums);
    }

    static void sort(int[] arrs) {
        if (arrs == null || arrs.length <= 1) {
            return;
        }
        initialize(arrs);
        for (int i = arrs.length - 1; i > 0; i--) {
            ArraysTool.swap(arrs, 0, i);
            siftDown(arrs, 0, i - 1);
        }
    }


    //从底层的第一个非叶子节点开始
    static void initialize(int[] arrs) {
        int firstParentIndex = (arrs.length >> 1) - 1;
        while (firstParentIndex >= 0) {
            siftDown(arrs, firstParentIndex, arrs.length - 1);
            firstParentIndex--;
        }
    }

    static void siftDown(int[] arrs, int start, int end) {

        //遍历不要超过最后一个非叶子节点
        int half = ((end + 1) >> 1) - 1;

        int i = start;
        while (i <= half) {
            int childIndex = (i << 1) + 1;
            if (childIndex + 1 <= end && arrs[childIndex + 1] > arrs[childIndex]) {
                childIndex++;
            }
            if (arrs[i] >= arrs[childIndex]) {
                break;
            }
            ArraysTool.swap(arrs, i, childIndex);
            i = childIndex;
        }
    }


}
