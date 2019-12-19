package com.leetcode.practice.search;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    List<List<Integer>> res =   new ArrayList<>();
    public static void main(String[] args) {
        int[] nums  =   {1,2,3};
        SubSets subSets =   new SubSets();
        List<List<Integer>> test    =   subSets.subsets(nums);
        for(List arr : test){
            System.out.println(arr.toString());
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        if(nums.length != 0){
            DFS(nums,new ArrayList<Integer>(),0);
        }

        return res;
    }

    private void DFS(int[] nums, ArrayList<Integer> tmpList, int start) {
        if (nums.length >= tmpList.size() && tmpList.size() > 0) {
            res.add(new ArrayList<>(tmpList));
        }

            for(int i = start; i < nums.length ; i++){
                tmpList.add(nums[i]);
                DFS(nums, tmpList, i+1);
                tmpList.remove(tmpList.size()-1);

            }
    }
}
