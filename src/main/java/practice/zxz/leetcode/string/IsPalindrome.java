package practice.zxz.leetcode.string;

/**
 * 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-01 15:54
 */

public class IsPalindrome {

    public static void main(String[] args) {

        String str = "0P";
        System.out.println(solution1(str));
    }

    static boolean solution1(String str) {
        if (str == null || str.equals("") || str.trim().equals("")) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        int middle = str.length() >>> 1;
        while (left <= middle && right >= middle) {
            char leftChar = str.charAt(left);
            if (!isAlphaOrNumber(leftChar)) {
                left++;
                continue;
            }
            char rightChar = str.charAt(right);
            if (!isAlphaOrNumber(rightChar)) {
                right--;
                continue;
            }
            if (equalIgnoreCase(leftChar, rightChar)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean equalIgnoreCase(char c1, char c2) {
        if (c1 == c2) {
            return true;
        }
        if (!isAlpha(c1) || !isAlpha(c2)) {
            return false;
        }
        if (c1 > c2) {
            return c1 - 32 == c2;
        } else {
            return c2 - 32 == c1;
        }
    }

    static boolean isAlphaOrNumber(char c) {
        return isNumber(c) || isAlpha(c);
    }

    static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

}
