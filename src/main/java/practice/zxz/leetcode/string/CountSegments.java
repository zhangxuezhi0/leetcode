package practice.zxz.leetcode.string;

/**
 * 字符串中的单词数
 * <p>
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-04 16:05
 */

public class CountSegments {

    public static void main(String[] args) {

//        String str = " str,s, str sr ,  s ";
        String str = "The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.";

        System.out.println(solution1(str));
    }

    static int solution1(String string) {
        string = string.trim();
        if(string.length()<=0){
            return 0;
        }
        int notAlpha = 0;
        int i = 0;
        while (i < string.length()) {
            if (!isAlpha(string.charAt(i))) {
                notAlpha++;
                while (i < string.length()-1 && !isAlpha(string.charAt(++i))) {
                }
            } else {
                i++;
            }
        }
        return notAlpha + 1;
    }

    static boolean isAlpha(char c) {
        return c!=' ';
    }

}
