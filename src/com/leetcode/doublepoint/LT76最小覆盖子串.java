package com.leetcode.doublepoint;

/**
 * leetcode 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 */
public class LT76最小覆盖子串 {
    public static void main(String[] args) {
        System.out.print(minWindow(
                "ADOBECODEBANC", "ABC"));
    }

    public static String minWindow (String s, String t) {
        int[] need = new int[128];//need[i]表示需要该元素的数量,0代表不需要, <0代表多余的数量
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int l = 0, r = 0;//i滑动窗口左端，j右端
        int minSize = Integer.MAX_VALUE;//当前发现的满足要求的最小窗口长度
        int needCnt = t.length();//所需元素的总数量
        int start = 0;
        while(r < s.length()){
            //// 窗口扩展时寻找可行解，窗口收缩时优化可行解
            // 1. 不断增加r 直到包含了全部的元素。 此步骤为寻找可行解
            // 2. 然后缩小l 直到碰到任何一个需要的元素 此时为最小窗口，记录值。此步骤为优化窗口
            // 3. 让l 再走一步  进去第一步的循环 重新寻找可能解

            // 是否可以定义一个 int 用于判断剩余多少需要匹配的个数 判断是否等于0
            char rChar = s.charAt(r);
            if(need[rChar] > 0){//新加入的字符使我们需要的元素
                needCnt--;
            }
            need[rChar]--;

            //此时窗窗口包含了T的所有元素，进入步骤二，增加i，扔掉不需要的元素
            if(needCnt == 0){
                char lChar = s.charAt(l);
                while(need[lChar] < 0){
                    //向右移动一格
                    need[lChar]++;
                    l++;
                    lChar = s.charAt(l);
                }
                if(r - l + 1 < minSize){
                    minSize = r - l + 1;
                    start = l;//只有发现最小值时才更新start
                }
                //步骤三：让i再向右移动一个位置，使窗口不再满足条件，让其再次寻找，进入步骤一

                need[s.charAt(l)]++;
                l++;
                needCnt++;
            }
            r++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start+minSize);
    }
}
