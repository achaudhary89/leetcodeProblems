package com.leetcode.practice.search;

import java.util.*;

public class SubSets {
    List<List<Integer>> res =   new ArrayList<>();
    public static void main(String[] args) {
        Integer[] nums  =   {5,3,5,7,11,2};//{5,2,3,2,3,3};
        SubSets subSets =   new SubSets();
        List<List<Integer>> test    =   subSets.subsets(Arrays.asList(nums));
        for(List arr : test){
            System.out.println(arr.toString());
        }
    }

    public List<List<Integer>> subsets(List<Integer> val) {
        Integer[] nums = new Integer[val.size()];
        nums = val.toArray(nums);
        if(nums.length != 0){
            DFS(nums,new ArrayList<Integer>(),0);
        }

        return res;
    }

    private void DFS(Integer[] nums, ArrayList<Integer> tmpList, int start) {
        if (nums.length >= tmpList.size() && tmpList.size() > 0 && gcd(tmpList.get(0), tmpList.get(tmpList.size()-1)) > 1) {
            res.add(new ArrayList<>(tmpList));
        }

            for(int i = start; i < nums.length ; i++){
                tmpList.add(nums[i]);
                DFS(nums, tmpList, i+1);
                tmpList.remove(tmpList.size()-1);

            }
    }

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a == b)
            return a;

        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
}
