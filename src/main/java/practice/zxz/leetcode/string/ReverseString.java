package practice.zxz.leetcode.string;

import first.zxz.tools.PrintTool;

/**
 * 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-01 16:58
 */

public class ReverseString {

    public static void main(String[] args) {

        char[] cs = "hello".toCharArray();
        solution1(cs);
        PrintTool.printCharArr(cs);
    }

    static void solution1(char[] cs) {
        if (cs == null || cs.length < 2) {
            return;
        }
        int left = 0;
        int right = cs.length - 1;
        int middle = cs.length >>> 1;
        while (left <= middle && right >= middle) {
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }
    }

}
