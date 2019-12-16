package com.leetcode.practice.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentNumbers {

    public static void main(String[] args) {

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res   =   new ArrayList<>(k);
        Map<Integer, Integer> map   =   new HashMap<>();

        for (int  i = 0 ; i < nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return map.entrySet().
                stream().
                sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).map(Map.Entry :: getKey).collect(Collectors.toList()).subList(0,k-1);

    }
}
