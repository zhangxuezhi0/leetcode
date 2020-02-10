package practice.zxz.leetcode.string;

import java.util.HashMap;

/**
 * 查找字符串
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-01-31 15:48
 */

public class StrStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "hllo";
        System.out.println(solution2(haystack, needle));
    }

    static int solution1(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() <= 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    //sunday算法
    static int solution2(String haystack, String needle) {
        if (needle == null || needle.length() <= 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        HashMap<Character, Integer> hashMap = calShiftTab(needle);
        int i = 0;
        while (i + needle.length() <= haystack.length()) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            } else {
                if (i + needle.length() == haystack.length()) {
                    return -1;
                }
                Integer shift = hashMap.get(haystack.charAt(i + needle.length()));
                if (shift != null) {
                    i += shift;
                } else {
                    i = i + needle.length() + 1;
                }
            }
        }
        return -1;
    }

    //偏移表
    static HashMap<Character, Integer> calShiftTab(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int length = str.length() - 1; length >= 0; length--) {
            if (!hashMap.containsKey(str.charAt(length))) {
                hashMap.put(str.charAt(length), str.length() - length);
            }
        }
        return hashMap;
    }

}
