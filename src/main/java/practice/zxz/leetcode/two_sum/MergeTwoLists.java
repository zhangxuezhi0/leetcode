
package practice.zxz.leetcode.two_sum;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author zhangxz
 * 2019/10/11
 */

public class MergeTwoLists {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(0);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(4);
        listNode2.next.next.next = new ListNode(5);
        listNode2.next.next.next.next = new ListNode(6);

        ListNode result = new ListNode();
        mergeTwoLists(listNode1, listNode2, result);
        ListNode.print(result.next);

        ListNode.print(mergeTwoLists(listNode1,listNode2));

    }

    /**
     * leetcode 官方题解
     * 算法
     * 我们直接将以上递归过程建模，首先考虑边界情况。
     * 特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个的头元素更小，然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
     *
     *
     * @author Zxz
     * @date 2019/10/12 9:55
     * @param l1
     * @param l2
     * @return practice.zxz.leetcode.two_sum.ListNode
     **/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    

    public static void mergeTwoLists(ListNode l1, ListNode l2, ListNode result) {
        if (l1 == null) {
            result.next = l2;
        }
        if (l2 == null) {
            result.next = l1;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }


    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode() {
    }

    public static void print(ListNode listnode) {
        while (listnode != null) {
            System.out.println(listnode.val);
            listnode = listnode.next;
        }
    }

}
