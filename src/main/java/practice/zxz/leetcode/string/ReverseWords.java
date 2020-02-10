package practice.zxz.leetcode.string;

/**
 * 反转单词
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-05 17:00
 */

public class ReverseWords {

    public static void main(String[] args) {

        String str = " str str2 ";
        System.out.println(solution1(str));
    }

    static String solution1(String string) {
        char[] chars = string.toCharArray();
        int len = chars.length;
        int out = 0;
        while (out < len) {
            if (chars[out] == ' ') {
                out++;
                continue;
            }
            int start = out;
            while (++out < len && chars[out] != ' ') {
            }
            //反转
            int end = out - 1;
            while (start < end) {
                char tmp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = tmp;
            }
        }

        return new String(chars);
    }

    static String solution2(String string) {
        String[] split = string.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            builder.append(new StringBuilder(s).reverse()).append(" ");
        }
        return builder.toString().trim();
    }

}
