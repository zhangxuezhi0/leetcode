package practice.zxz.leetcode.string;

import java.util.HashSet;

/**
 * 反转元音字母
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-01 17:09
 */

public class ReverseVowels {

    public static void main(String[] args) {

        String str = "leetcode";
        System.out.println(solution1(str));
    }

    static String solution1(String string) {
        if (string == null || string.length() < 2) {
            return string;
        }
        char[] toCharArray = string.toCharArray();
        int left = 0;
        int right = toCharArray.length - 1;
        while (left < right) {
            char leftC = toCharArray[left];
            char rightC = toCharArray[right];

            if (!isVowel(leftC)) {
                left++;
                continue;
            }
            if (!isVowel(rightC)) {
                right--;
                continue;
            }

            //swap
            char temp = toCharArray[left];
            toCharArray[left] = toCharArray[right];
            toCharArray[right] = temp;
            left++;
            right--;
        }
        return new String(toCharArray);
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                ||c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';

//        HashSet<Character> hashSet = new HashSet<>();
//        hashSet.add('a');
//        hashSet.add('e');
//        hashSet.add('i');
//        hashSet.add('o');
//        hashSet.add('u');
//
//        hashSet.add('A');
//        hashSet.add('E');
//        hashSet.add('I');
//        hashSet.add('O');
//        hashSet.add('U');
//        return hashSet.contains(c);
    }

}
