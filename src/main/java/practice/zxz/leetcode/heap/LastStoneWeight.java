package practice.zxz.leetcode.heap;

import first.zxz.comparator.Comparators;
import first.zxz.tools.ArraysTool;

import java.util.PriorityQueue;

/**
 * 最后一块石头的重量
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-21 16:23
 */

public class LastStoneWeight {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] stones = new int[]{3, 2, 5, 7, 11};
        System.out.println(mySolution2(stones));
    }

    //直接使用java内置的优先队列来实现
    static int mySolution2(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(stones.length, new Comparators.IntReverse());
        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() >= 2) {
            Integer poll = priorityQueue.poll();
            Integer poll1 = priorityQueue.poll();
            int sub = poll - poll1;
            if (sub > 0) {
                priorityQueue.add(sub);
            }
        }
        if (priorityQueue.size() <= 0) {
            return 0;
        }
        return priorityQueue.peek();
    }

    //自己构建堆
    static int mySolution1(int[] stones) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight(stones);
        return lastStoneWeight.mySolution1();
    }

    private int[] stones;
    private int size = 0;

    public LastStoneWeight(int[] stones) {
        this.stones = stones;
        this.size = this.stones == null ? 0 : this.stones.length;
    }

    //使用大顶堆
    //时间复杂度：O(logn)
    int mySolution1() {
        if (stones == null || stones.length <= 0) {
            return 0;
        }
        initializeStones(stones);
        while (size >= 2) {
            //获取两个最重的石头
            int max = poll();
            int secondMax = peak();
            int sub = max - secondMax;
            if (sub == 0) {
                poll();
            } else {
                stones[0] = sub;
                siftDown(stones, 0, size - 1);
            }
        }

        if (size <= 0) {
            return 0;
        }
        return stones[0];

    }

    private int peak() {
        return stones[0];
    }

    int poll() {
        int result = stones[0];
        stones[0] = stones[--size];
        siftDown(stones, 0, size - 1);
        return result;
    }


    //初始化堆
    private static void initializeStones(int[] stones) {
        int firstPIndex = (stones.length >> 1) - 1;
        for (int i = firstPIndex; i >= 0; i--) {
            siftDown(stones, i, stones.length - 1);
        }
    }

    //自上而下调整
    private static void siftDown(int[] stones, int start, int end) {
        int i = start;
        int firstPIndex = ((end + 1) >> 1) - 1;
        while (i <= firstPIndex) {
            int childIndex = (i << 1) + 1;
            if (childIndex + 1 <= end && stones[childIndex + 1] > stones[childIndex]) {
                //右孩子节点值更大
                childIndex++;
            }
            if (stones[i] >= stones[childIndex]) {
                break;
            }
            ArraysTool.swap(stones, i, childIndex);
            i = childIndex;
        }
    }

}
