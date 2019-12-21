package practice.zxz.leetcode.heap;

import first.zxz.tools.ArraysTool;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 实现一个堆
 * 小顶堆（大顶堆）：完全二叉树，并且父节点不大于（或小于）子节点
 * <p>
 * <p>
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.addAndRemove，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.addAndRemove(3);   // returns 4
 * kthLargest.addAndRemove(5);   // returns 5
 * kthLargest.addAndRemove(10);  // returns 5
 * kthLargest.addAndRemove(9);   // returns 8
 * kthLargest.addAndRemove(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-13 11:46
 */

public class KthLargestUsingHeap {

    public static void main(String[] args) {
        int k = 2;
        int[] nums = new int[]{0};
        KthLargest2 kthLargest = new KthLargest2(k, nums);
        System.out.println(kthLargest.addAndRemove(-1));
        System.out.println(kthLargest.addAndRemove(1));
        System.out.println(kthLargest.addAndRemove(-2));
        System.out.println(kthLargest.addAndRemove(-4));
        System.out.println(kthLargest.addAndRemove(3));
    }

    static class KthLargest2 {
        private int k;
        private PriorityQueue<Integer> priorityQueue;

        public KthLargest2(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>(k);
            for (int num : nums) {
                addAndRemove(num);
            }
        }

        int addAndRemove(int val) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(val);
            } else if (priorityQueue.peek() < val) {
                priorityQueue.add(val);
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }
    }

    //小顶堆
    static class KthLargest {

        private int kth;
        private int[] nums;

        public KthLargest(int k, int[] nums) {
            this.kth = k;
            initialize(nums);
        }

        private void initialize(int[] arrs) {
            this.nums = arrs;
            if (arrs == null || arrs.length <= 0) {
                return;
            }
            for (int i = (this.nums.length >> 1) - 1; i >= 0; i--) {
                //从最后一个非叶子节点往上遍历直到根，每一次都进行自上向下调整
                adjustDown(i);
            }
            //从数组删除数据最小的数据，直到只剩下k个，因此要删除的次数为：n - k
            for (int i = 0; i < arrs.length - kth; i++) {
                removeTop();
            }

        }

        //自上向下调整，直到最后一个非叶子节点
        //每次进行该节点和其子节点的大小比较和交换，注意其右子节点可能不存在
        //如果有任何一次比较当前节点比子节点都小，则可以提前结束
        private void adjustDown(int i) {
            int finalParentIndex = (nums.length >> 1) - 1;
            while (i <= finalParentIndex) {

                //代码优化
                int minIndex = (i << 1) + 1;
                if (minIndex + 1 <= nums.length - 1 && nums[minIndex] > nums[minIndex + 1]) {
                    minIndex += 1;
                }
                if (nums[i] <= nums[minIndex]) {
                    //父节点比较大，提前结束
                    break;
                } else {
                    ArraysTool.swap(nums, i, minIndex);
                    i = minIndex;
                }
                /*

                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                int leftChild = nums[leftIndex];
                int parent = nums[i];

                if (rightIndex > this.nums.length - 1) {
                    //没有右子节点，可能的情况只会发生在最后一个非叶子节点上。
                    if (this.nums[i] > leftChild) {
                        ArraysTool.swap(this.nums, i, leftIndex);
                        i = leftIndex;
                    } else {
                        break;
                    }
                } else {
                    //有右子节点
                    int rightChild = this.nums[rightIndex];
                    if (leftChild < rightChild && leftChild < parent) {
                        //左子节点比较小，且小于其父节点
                        ArraysTool.swap(this.nums, i, leftIndex);
                        i = leftIndex;
                    } else if (rightChild <= leftChild && rightChild < parent) {
                        //右子节点比较小，且小于其父节点
                        ArraysTool.swap(this.nums, i, rightIndex);
                        i = rightIndex;
                    } else {
                        break;
                    }
                }*/
            }
        }

        private void addNode(int num) {
            nums = Arrays.copyOf(nums, nums.length + 1);
            nums[nums.length - 1] = num;
            adjustUp(nums.length - 1);
        }


        //自底向上调整堆结构
        //比较尾节点与其父节点的大小，如果尾节点不小于父节点，则结束，否则两者交换，然后递归比较
        //时间复杂度：O(log(n))，空间复杂度：O(1)
        private void adjustUp(int index) {
            if (index == 0) {
                return;
            }
            int parentIndex = (index - 1) / 2;
            if (nums[index] < nums[parentIndex]) {
                //交换
                ArraysTool.swap(nums, index, parentIndex);
                adjustUp(parentIndex);
            }
        }

        public int addAndRemove(int val) {
            if (nums.length < kth) {
                addNode(val);
            } else if (val > nums[0]) {
                addNode(val);
                removeTop();
            }
            return nums[0];
        }

        //删除根节点，从上往下调整堆
        private void removeTop() {
            nums[0] = nums[nums.length - 1];
            nums = Arrays.copyOf(nums, nums.length - 1);
            //调整
            adjustDown(0);
        }


    }

}
