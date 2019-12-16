package com.leetcode.practice.subArray;

public class NiceArray {

    public static void main(String[] args) {
        NiceArray niceArray =   new NiceArray();
        int[] a =   {1,1,2,1,1};
        System.out.println(niceArray.numberOfSubarrays( a, 3));
    }

    public int numberOfSubarrays(int[] nums, int k) {

        int start = 0;
        int max = 0;
        int count = 0;

        for (int i = 0 ; i < nums.length ; i++){

            if(nums[i]%2 == 1){
                count++;
            }

            while(count >= k){
                if(nums[start]%2 == 0){
                    start++;
                    max++;
                }else{
                    count--;
                }

            }

            max = Math.max(max, i-start+1);
        }

        return max;

    }
}
