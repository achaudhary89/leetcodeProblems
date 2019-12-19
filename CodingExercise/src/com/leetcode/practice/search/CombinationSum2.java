package com.leetcode.practice.search;

import java.util.*;

public class CombinationSum2 {

    List<List<Integer>> res =   new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        int[] tmp   =   {10,1,2,7,6,1,5};
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> test    =   combinationSum2.combinationSum(tmp, 8);
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

        else if(remain == 0 && !set.contains(tempArray)){
            res.add(new ArrayList<>(tempArray));
            set.add(tempArray);
        }else{

            for (int i = start ; i < candidates.length ; i++){
                tempArray.add(candidates[i]);
                DFS(candidates, remain-candidates[i],tempArray,i+1);
                tempArray.remove(tempArray.size()-1);
            }

        }

    }
}
