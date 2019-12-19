package com.leetcode.practice.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCobinations {
    List<String> res    =   new ArrayList<>();
    public static void main(String[] args) {
        PhoneNumberCobinations phoneNumberCobinations   =   new PhoneNumberCobinations();
        System.out.println(phoneNumberCobinations.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        String[] map = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length() != 0 ){
            DFS("",digits,map);
        }
        return res;
    }

    private void DFS(String s, String digits, String[] map) {
        if(digits.length() == 0){
            res.add(s);
        }else{
            String digit = digits.substring(0,1);
            String letters  =   map[Integer.valueOf(digit)];
            for(int i = 0; i < letters.length() ; i++){
                String letter   =   map[Integer.valueOf(digit)].substring(i,i+1);
                DFS(s+letter,digits.substring(1),map);
            }
        }

    }
}
