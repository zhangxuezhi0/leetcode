package practice.zxz.leetcode.string;

import java.util.*;

/**
 * 第一个唯一字符
 * <p>
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-04 12:06
 */

public class FirstUniqueChar {

    public static void main(String[] args) {

        String str = "love";
        System.out.println(solution1(str));
    }

    static int solution2(String string) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            hashMap.put(string.charAt(i), hashMap.getOrDefault(string.charAt(i), 0) + 1);
        }
        for (int i = 0; i < string.length(); i++) {
            if (hashMap.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    static int solution1(String str) {
        //保存只出现一次的字符的索引
        HashMap<Character, CharEntity> hashMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (hashMap.containsKey(chars[i])) {
                hashMap.get(chars[i]).inc();
            } else {
                hashMap.put(chars[i], new CharEntity(i));
            }
        }

        Collection<CharEntity> values = hashMap.values();
        if (values.size() < 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (CharEntity value : values) {
            if (value.times == 1) {
                list.add(value.firstIndex);
            }
        }
        if (list.size() <= 0) {
            return -1;
        }
        return Collections.min(list);
    }

    static class CharEntity implements Comparable {
        //字符第一次出现索引
        Integer firstIndex;
        //字符出现的次数
        int times;

        public int getTimes() {
            return times;
        }

        void inc() {
            this.times++;
        }

        public CharEntity(int firstIndex) {
            this.firstIndex = firstIndex;
            this.times = 1;
        }

        @Override
        public int compareTo(Object o) {
            if (o == null || !(o instanceof CharEntity)) {
                return 1;
            }
            CharEntity that = (CharEntity) o;
            return this.firstIndex - that.firstIndex;
        }
    }

}
