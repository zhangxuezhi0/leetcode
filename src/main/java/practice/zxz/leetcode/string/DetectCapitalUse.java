package practice.zxz.leetcode.string;

/**
 * 单词的正确格式
 * <p>
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "FlaG"
 * 输出: False
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-04 18:56
 */

public class DetectCapitalUse {

    public static void main(String[] args) {
        String a = null;
    }

    static boolean solution1(String string) {
        char[] chars = string.toCharArray();
        char firstChar = string.charAt(0);
        boolean isFirstCapital = (firstChar >= 'A' && firstChar <= 'Z');

        boolean hasBig = false;
        boolean hasSmall = false;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                hasBig = true;
            } else {
                hasSmall = true;
            }
            if (hasBig && hasSmall) {
                return false;
            }
        }
        if (!isFirstCapital && hasBig) {
            return false;
        }
        return true;
    }

}
