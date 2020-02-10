package practice.zxz.leetcode.string;

/**
 * 学生出勤记录
 * <p>
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "PPALLL"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-02-05 16:47
 */

public class CheckRecord {

    public static void main(String[] args) {

        String str = "PALLPPLLPA";
        System.out.println(solution1(str));
    }

    static boolean solution1(String string) {
        int aCount = 0;
        int lCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'A') {
                aCount++;
                lCount = 0;
                if (aCount > 1) {
                    return false;
                }
            } else if (string.charAt(i) == 'L') {
                lCount++;
                if (lCount > 2) {
                    return false;
                }
            } else {
                lCount = 0;
            }
        }
        return true;
    }

}
