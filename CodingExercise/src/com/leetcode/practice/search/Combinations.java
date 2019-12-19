package com.leetcode.practice.search;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    List<List<Integer>> res =   new ArrayList<>();

    public static void main(String[] args) {
        Combinations combinations   =   new Combinations();
        List<List<Integer>> test    =   combinations.combine(4, 2);
        for(List arr : test){
            System.out.println(arr.toString());
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        if(n != 0 ){
            DFS(n,k,new ArrayList<Integer>(), 1);
        }

        return res;
    }

    private void DFS(int n, int k, ArrayList<Integer> tmpList, int start) {
        if(k < 0) {
            return;
        }else if(tmpList.size() == k){
            res.add(new ArrayList<>(tmpList));
        }else{
            for (int i = start; i <= n ;i++) {
                tmpList.add(i);
                DFS(n,k,tmpList,i+1);
                tmpList.remove(tmpList.size()-1);
            }

        }
    }
}
