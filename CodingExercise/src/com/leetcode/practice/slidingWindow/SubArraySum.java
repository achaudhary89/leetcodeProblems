package com.leetcode.practice.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArraySum {
    public static void main(String[] args) {
        int [] nums = {-1,-1,1};//{1,2,3};
        SubArraySum subArraySum =   new SubArraySum();
        System.out.println(subArraySum.subarraySum(nums, 0));
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        if(nums.length == 0){
            return count;
        }

        if(nums.length == 1){
            return nums[0] == k ? 1 : 0;
        }

        while (i < nums.length){

                sum += nums[i++];
                if(sum == k){
                    ++count;
                }

            while(sum >= k){
                sum -= nums[j++];
                if(sum == k){
                    ++count;
                }
            }
        }
        return count;
    }


}
