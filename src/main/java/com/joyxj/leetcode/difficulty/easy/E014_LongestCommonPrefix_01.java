package com.joyxj.leetcode.difficulty.easy;

/**
 * 官方解题中的解法一:水平扫描法：LCP(S1..Sn)=LCP(LCP(LCP(S1,S2),S3)..SN)
 * 依次遍历字符串[S1...SN]，当遍历到第i个字符串的时候，找到最长公共前缀LCP(S1...Si)，当LCP(S1...Si)是一个空串的时候算法结束。否则在执行n次遍历后，算法返回最终的答案(S1...SN)
 * @author xiaoj
 */
public class E014_LongestCommonPrefix_01 {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(new E014_LongestCommonPrefix_01().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //最初的公共前缀为LCP(S0)
        String prefix = strs[0];
        for (int i = 1,len= strs.length; i < len; i++) {
            //一直循环到第i个元素是以Prefix开头为止
           while(strs[i].indexOf(prefix)!=0) {
                //不是以prefix开头，则prefix减少一个元素
                prefix = prefix.substring(0, prefix.length() -1);
           }
           //当公共前缀是空的情况下，则不需要在进行循环了
           if (prefix.isEmpty()) {
               break;
           }      
        }
        return prefix;
    }
}