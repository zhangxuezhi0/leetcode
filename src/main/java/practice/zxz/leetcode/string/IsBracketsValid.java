package practice.zxz.leetcode.string;

import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangxz
 * @date 2020-01-31 12:05
 */

public class IsBracketsValid {

    public static void main(String[] args) {
        String string = "(){}[{()}])";
        System.out.println(solution1(string));
    }

    static void testStack() {

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push("f");
        stack.push("g");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static boolean solution1(String str) {
        if (str == null || str.length() < 1) {
            return true;
        }
        if (str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (isLeftBracket(charAt)) {
                stack.push(charAt);
            } else {
                try {
                    Character pop = stack.pop();
                    if (!matchesBrackets(charAt, pop)) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }

            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    static boolean isLeftBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    static boolean matchesBrackets(char c1, char c2) {
        return c1 == '(' && c2 == ')' || c1 == ')' && c2 == '('
                || c1 == '[' && c2 == ']' || c1 == ']' && c2 == '['
                || c1 == '{' && c2 == '}' || c1 == '}' && c2 == '{';
    }

}
