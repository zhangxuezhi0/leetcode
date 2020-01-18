package practice.zxz.leetcode.string;

/**
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-01-18 11:28
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String [] str = new String[]{"fight", "fighting", "five", "fighting"};
//        System.out.println(mySolution1(str));
//
        String str = "fight";
        String str1 = "fighting";
        System.out.println(str.indexOf(str1));
        System.out.println(str1.indexOf(str));

    }

    static String mySolution1(String[] str) {
        String commPrefix = str[0];
        for (int i = 1; i < str.length; i++) {
            char[] chars0 = commPrefix.toCharArray();
            char[] chars1 = str[i].toCharArray();
            StringBuilder builder = new StringBuilder();
            int j = 0;
            int min = Math.min(chars0.length, chars1.length);
            while (j < min) {
                if (chars0[j] == chars1[j]) {
                    builder.append(chars0[j]);
                } else {
                    break;
                }
                j++;
            }
            if (builder.length() < 1) {
                return "";
            }
            commPrefix = builder.toString();
        }
        return commPrefix;
    }

}
