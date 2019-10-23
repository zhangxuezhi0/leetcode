
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
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        ListNode.print(listNode);

        System.out.println("===官方题解===");
        ListNode mergeTwoLists2 = mergeTwoLists2(listNode1, listNode2);
        ListNode.print(mergeTwoLists2);

        //如果再次执行下面这个调用，则在输出链表数据时会陷入死循环，
        /*System.out.println("===官方题解2===");
        ListNode mergeTwoLists3 = mergeTwoLists2(listNode1, listNode2);
        ListNode.print(mergeTwoLists3);*/

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //这两个判断可以不需要，因为循环里面已经有条件判断
        /*if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }*/

        ListNode result = new ListNode();
        //保存头指针，方便输出
        ListNode resultHead = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                //这里可以不new新的节点，可以节省空间；不需要担心l1后面的所有节点都加入到了新链表上，对新链表产生的影响，
                //但是注意，这种做法有个副作用，就是会改变原来的l1,l2的数据，
//                result.next = l1;
                //而这种做法，虽然耗费额外的空间，但是对于原来的数据l1和l2不会有影响
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
//                result.next = l2;
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }

        //这几行代码可以用3元运算符 ? :替换，更加简洁
        /*if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }*/
        result.next = l1 != null ? l1 : l2;
        return resultHead.next;
    }

    /**
     * 官方题解
     * 算法
     * 我们直接将以上递归过程建模，首先考虑边界情况。
     * 特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个的头元素更小，然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
     * <p>
     * 注意，该方法会修改l1和l2的数据，l1变成了： 1->2->3->4->4，l2变成了：1->1->2->3->4->4，并且l2的第2个节点开始是引用的l1的数据，也就是两者是共享部分内存数据的。
     * 而这种数据结构，如果被类似递归的方法重新调用的话，可能产生两个链表互相引用的情况，形成引用环，那在遍历两个链表时，就会陷入死循环，最后可能会导致内存耗尽系统崩溃。
     *
     * @param l1
     * @param l2
     * @return practice.zxz.leetcode.two_sum.ListNode
     * @author Zxz
     * @date 2019/10/12 10:44
     **/
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }

    /**
     作者：LeetCode
     链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

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