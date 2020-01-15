package com.leetcode.practice.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        LongestSubString longestSubString   =   new LongestSubString();
        System.out.println(longestSubString.lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet  =   new HashSet<Character>();
        int res =   0;
        int len = s.length();
        int j = 0; int i = 0;

       for ( i=0; i < len; ){
           if(!charSet.contains(s.charAt(i))) {
               charSet.add(s.charAt(i++));
               res = Math.max(res, charSet.size());
           }else {
              charSet.remove(s.charAt(j++));
           }
       }

       /* while(j < len) {
            if(!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j++));
                res	=	Math.max(res, charSet.size());
            }else {
                charSet.remove(s.charAt(i++));
            }


        }*/
       return res;
    }
}
