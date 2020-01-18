package practice.zxz.leetcode.string;

import java.util.HashMap;

/**
 * 罗马数字转阿拉伯数字
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-01-18 10:15
 */

public class Roman2Int {

    public static void main(String[] args) {
        String romans = "III";
        System.out.println(mySolution1(romans));
        String romans2 = "MCMXCIV";
        System.out.println(mySolution1(romans2));
    }

    static int mySolution3(String romans) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("IV", 4);
        hashMap.put("V", 5);
        hashMap.put("IX", 9);
        hashMap.put("X", 10);
        hashMap.put("XL", 40);
        hashMap.put("L", 50);
        hashMap.put("XC", 90);
        hashMap.put("C", 100);
        hashMap.put("CD", 400);
        hashMap.put("D", 500);
        hashMap.put("CM", 900);
        hashMap.put("M", 1000);

        char[] chars = romans.toCharArray();
        int i = 0;
        int sum = 0;
        while (i < chars.length) {
            Integer val = null;
            if (i + 1 < chars.length && (val = hashMap.get(romans.substring(i, i + 2))) != null) {
                sum += val;
                i += 2;
            } else {
                sum += hashMap.get(chars[i] + "");
                i++;
            }
        }
        return sum;
    }

    static int mySolution2(String romans) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("IV", 4);
        hashMap.put("IX", 9);
        hashMap.put("XL", 40);
        hashMap.put("XC", 90);
        hashMap.put("CD", 400);
        hashMap.put("CM", 900);

        HashMap<Character, Integer> specialChar = new HashMap<>();
        specialChar.put('I', 1);
        specialChar.put('X', 10);
        specialChar.put('C', 100);
        char[] chars = romans.toCharArray();
        int i = 0;
        int sum = 0;
        while (i < chars.length) {
            int step = 1;
            Integer charVal = specialChar.get(chars[i]);
            if (charVal != null) {
                if (i + 1 < chars.length) {
                    Integer integer = hashMap.get(chars[i] + "" + chars[i + 1]);
                    if (integer != null) {
                        sum += integer;
                        step = 2;
                    } else {
                        sum += charVal;
                    }
                } else {
                    sum += charVal;
                }
            } else if ('V' == chars[i]) {
                sum += 5;
            } else if ('L' == chars[i]) {
                sum += 50;
            } else if ('D' == chars[i]) {
                sum += 500;
            } else if ('M' == chars[i]) {
                sum += 1000;
            }
            i += step;
        }
        return sum;
    }

    static int mySolution1(String romans) {
        char[] chars = romans.toCharArray();
        int i = 0;
        int sum = 0;
        while (i < chars.length) {
            int step = 1;
            if ('I' == chars[i]) {
                if (i + 1 < chars.length) {
                    if (chars[i + 1] == 'V') {
                        sum += 4;
                        step = 2;
                    } else if (chars[i + 1] == 'X') {
                        sum += 9;
                        step = 2;
                    } else {
                        sum += 1;
                    }
                } else {
                    sum += 1;
                }
            } else if ('V' == chars[i]) {
                sum += 5;
            } else if ('X' == chars[i]) {
                if (i + 1 < chars.length) {
                    if (chars[i + 1] == 'L') {
                        sum += 40;
                        step = 2;
                    } else if (chars[i + 1] == 'C') {
                        sum += 90;
                        step = 2;
                    } else {
                        sum += 10;
                    }
                } else {
                    sum += 10;
                }
            } else if ('L' == chars[i]) {
                sum += 50;
            } else if ('C' == chars[i]) {
                if (i + 1 < chars.length) {
                    if (chars[i + 1] == 'D') {
                        sum += 400;
                        step = 2;
                    } else if (chars[i + 1] == 'M') {
                        sum += 900;
                        step = 2;
                    } else {
                        sum += 100;
                    }
                } else {
                    sum += 100;
                }
            } else if ('D' == chars[i]) {
                sum += 500;
            } else if ('M' == chars[i]) {
                sum += 1000;
            }
            i += step;
        }
        return sum;
    }


}
