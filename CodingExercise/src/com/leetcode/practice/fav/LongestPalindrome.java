package com.leetcode.practice.fav;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome =   new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int i = 0;
        int j = s.length();
        int count = 0;



        return s.substring(0,1);
    }

    public boolean check(String s){
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;

    }

}
