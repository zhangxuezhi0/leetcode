package practice.zxz.leetcode.string;

/**
 * 二叉树转字符串
 * <p>
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 * <p>
 * 输入: 二叉树: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-10 22:41
 */

public class Tree2Str {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
//        treeNode2.right = treeNode5;

        System.out.println(solution1(treeNode1));

    }

    //TODO为什么solution1比solution2快？？？
    static String solution1(TreeNode treeNode) {
        if (treeNode == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(treeNode.val);
        if (treeNode.left == null && treeNode.right == null) {
            return builder.toString();
        } else if (treeNode.left == null) {
            builder.append("()");
            builder.append("(").append(solution1(treeNode.right)).append(")");
            return builder.toString();
        } else if (treeNode.right == null) {
            builder.append("(").append(solution1(treeNode.left)).append(")");
            return builder.toString();
        } else {
            builder.append("(").append(solution1(treeNode.left)).append(")");
            builder.append("(").append(solution1(treeNode.right)).append(")");
            return builder.toString();
        }
    }

    static String solution2(TreeNode treeNode) {
        if (treeNode == null) {
            return "";
        }
        if (treeNode.left == null && treeNode.right == null) {
            return treeNode.val + "";
        } else if (treeNode.left == null) {
            return treeNode.val + "()" + "(" + solution2(treeNode.right) + ")";
        } else if (treeNode.right == null) {
            return treeNode.val + "(" + solution2(treeNode.left) + ")";
        } else {
            return treeNode.val + "(" + solution2(treeNode.left) + ")(" + solution2(treeNode.right) + ")";
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
