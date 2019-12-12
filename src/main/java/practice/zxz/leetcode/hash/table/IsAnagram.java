package practice.zxz.leetcode.hash.table;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2019-12-06 22:37
 */

public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(mySolution1("abc", "abc"));
        System.out.println(mySolution1("abc", "abc1"));
        System.out.println(mySolution1("a1bc", "abc1"));
    }

    static boolean officialSolution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s == t || s.equals(t)) {
            return true;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        //计算两个字符串中字符（都是小写字母）的个数是否相等
        int[] alphaArr = new int[26];

        //优化点：可以先计算统计其中一个的字母个数，完了之后用另外一个去减，如果出现了负数，则直接返回false
//        for (int i = 0; i < schars.length; i++) {
//            alphaArr[schars[i] - 'a']++;
//            alphaArr[tchars[i] - 'a']--;
//        }
        for (int i = 0; i < schars.length; i++) {
            alphaArr[schars[i] - 'a']++;
        }
        for (int i = 0; i < tchars.length; i++) {
            if (--alphaArr[tchars[i] - 'a'] < 0) {
                return false;
            }
        }

        for (int i : alphaArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }

    static class CIHashMap extends HashMap<Character, Integer> {
        public Integer inc(Character key) {
            if (!this.containsKey(key)) {
                return this.put(key, 1);
            } else {
                return this.put(key, this.get(key) + 1);
            }
        }

        public Integer decr(Character key) {
            if (!this.containsKey(key)) {
                return this.put(key, -1);
            } else {
                return this.put(key, this.get(key) - 1);
            }
        }
    }

    //受到官方题解的启发，使用hashmap来处理，但是效率好像不高
    static boolean officialSolution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        CIHashMap hashMap = new CIHashMap();
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        for (int i = 0; i < schars.length; i++) {
            hashMap.inc(schars[i]);
            hashMap.decr(tchars[i]);
        }

        for (Integer integer : hashMap.values()) {
            if (integer != null && integer != 0) {
                return false;
            }
        }
        return true;
    }

    //默认字符串不为空
    //优化点：可以先判断字符串长度，然后再判断是否相等
    static boolean mySolution1(String s, String t) {

        if (s.equals(t)) {
            return true;
        }

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        if (schars.length != tchars.length) {
            return false;
        }

        Arrays.sort(schars);
        Arrays.sort(tchars);
        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }
        return true;

    }

}
