package practice.zxz.leetcode.string;

/**
 * 赎金信
 * <p>
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-01 17:54
 */

public class CanConstruct {

    public static void main(String[] args) {
        String string = "";

        System.out.println(solution1("aba", "abca"));
    }

    static boolean solution1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] magazineAlpha = new int[26];
        char[] magazineChars = magazine.toCharArray();
        for (char magazineChar : magazineChars) {
            magazineAlpha[magazineChar - 'a']++;
        }

        char[] ransomChars = ransomNote.toCharArray();
        for (char aChar : ransomChars) {
            magazineAlpha[aChar - 'a']--;
            if (magazineAlpha[aChar - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
