package practice.zxz.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 外观数列
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-01-31 17:00
 */

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(solution1(1));
        System.out.println(solution1(2));
        System.out.println(solution1(3));
        System.out.println(solution1(4));
        System.out.println(solution1(5));
    }

    static String solution1(int n) {
        List<String> list = new ArrayList<>(n);
        if (n <= 1) {
            return "1";
        }
        list.add("1");
        for (int i = 1; i < n; i++) {
            String previous = list.get(i - 1);
            int j = 0;
            StringBuilder builder = new StringBuilder();
            while (j < previous.length()) {
                String flag = previous.substring(j, j + 1);
                int times = 1;
                while (j + times < previous.length() && flag.equals(previous.substring(j + times, j + times + 1))) {
                    times++;
                }
                builder.append(String.valueOf(times)).append(flag);
                j += times;
            }
            list.add(builder.toString());
        }
        return list.get(n - 1);
    }

}
