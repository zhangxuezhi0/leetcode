package practice.zxz.leetcode.string;

/**
 * 二进制求和
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-01-31 18:09
 */

public class AddBinary {

    public static void main(String[] args) {
        String a = "101111";
        String b = "10";
        System.out.println(solution1(a, b));
    }

    //官网题解区有个巧妙的解法：把两个字符串中较短的字符串前面补0，两者长度即相等，然后通过除法获得进位，通过求余获得每一位计算结果
    static String solution1(String a, String b) {
        StringBuilder builder = new StringBuilder();
        String longer = a;
        String shorter = b;
        if (a.length() < b.length()) {
            longer = b;
            shorter = a;
        }

        String longerLow = longer.substring(longer.length() - shorter.length(), longer.length());

        boolean carry = false;
        for (int length = shorter.length() - 1; length >= 0; length--) {
            if (longerLow.charAt(length) == '0' && shorter.charAt(length) == '0') {
                if (carry) {
                    builder.append('1');
                } else {
                    builder.append('0');
                }
                carry = false;
            } else if ((longerLow.charAt(length) == '1' && shorter.charAt(length) == '1')) {
                if (carry) {
                    builder.append('1');
                } else {
                    builder.append('0');
                }
                carry = true;
            } else {
                if (carry) {
                    builder.append('0');
                } else {
                    builder.append('1');
                    carry = false;
                }
            }
        }

        String longerHigh = longer.substring(0, longer.length() - shorter.length());
        for (int i = longerHigh.length() - 1; i >= 0; i--) {
            if (carry) {
                if (longerHigh.charAt(i) == '0') {
                    builder.append("1");
                    carry = false;
                } else {
                    builder.append("0");
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder(longerHigh.substring(0, i + 1));
                builder.append(stringBuilder.reverse());
                break;
            }
        }

        if (carry) {
            builder.append("1");
        }

        return builder.reverse().toString();
    }

}
