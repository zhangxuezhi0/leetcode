package practice.zxz.leetcode.string;

/**
 * 反转字符串
 * <p>
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 * <p>
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-05 16:01
 */

public class ReverseStr {

    public static void main(String[] args) {

        String str = "abcdae";
        int k = 3;
        System.out.println(solution1(str, k));
    }

    static String solution1(String string, int k) {
        int len = string.length();
        if (len <= k) {
            return reverse(string);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i += 2 * k) {
            builder.append(reverse(string.substring(i, i + k < len ? i + k : len)));
            if (i + k < len) {
                builder.append(string.substring(i + k, i + 2 * k < len ? i + 2 * k : len));
            }
/*
            if (i + k < len) {
                builder.append(reverse(string.substring(i, i + k)));
                //k搭配2k
                if (i + 2 * k < len) {
                    builder.append(string.substring(i + k, i + 2 * k));
                } else {
                    builder.append(string.substring(i + k, len));
                }
            } else {
                builder.append(reverse(string.substring(i, len)));
            }*/
        }
        return builder.toString();
    }

    static String reverse(String string) {
        int length = string.length();
        int middle = length >>> 1;
        char[] chars = string.toCharArray();
        for (int i = 0, j = length - 1; i < middle && j >= middle; i++, j--) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
        return new String(chars);
    }

    static String solution2(String string, int k) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int j = Math.min(chars.length - 1, i + k - 1);
            //反转字符串
            while (start < j) {
                char tmp = chars[start];
                chars[start++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);
    }

}
