package com.leetcode.practice.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res =   new ArrayList<>();
    public static void main(String[] args) {
        int[] tmp   =   {10,1,2,7,6,1,5};
        CombinationSum combinationSum   =   new CombinationSum();
        List<List<Integer>> test    =   combinationSum.combinationSum(tmp, 8);
        for(List arr : test){
            System.out.println(arr.toString());
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if(candidates.length != 0){
             DFS(candidates, target, new ArrayList<Integer>(),0);
        }

        return res;
    }

    private void DFS(int[] candidates, int remain, ArrayList<Integer> tempArray, int start) {
        if(remain < 0 ){
            return ;
        }

        else if(remain == 0){
            res.add(new ArrayList<>(tempArray));
        }else{

            for (int i = start ; i < candidates.length ; i++){
                tempArray.add(candidates[i]);
                DFS(candidates, remain-candidates[i],tempArray,i);
                tempArray.remove(tempArray.size()-1);
            }

        }

    }

}
