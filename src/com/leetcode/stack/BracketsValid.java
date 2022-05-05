package com.leetcode.stack;

import java.util.Stack;

/**
 * leetcode 20. 有效的括号描述
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * 数据范围：字符串长度 0\le n \le 100000≤n≤10000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 *
 * 示例1
 * 输入：
 * "()[]{}"
 * 复制
 * 返回值：
 * true
 */
public class BracketsValid {

    public boolean isValid (String s) {
        // write code here\
        if (s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                Character pop = stack.pop();
                switch (c) {
                    case ')':
                        if (pop != '(') return false;
                        break;
                    case '}':
                        if (pop != '{') return false;
                        break;
                    case ']':
                        if (pop != '[') return false;
                        break;
                }

            }

        }

        return stack.empty();
    }
}
