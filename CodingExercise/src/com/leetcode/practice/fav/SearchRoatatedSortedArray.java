package com.leetcode.practice.fav;

import java.util.Arrays;

public class SearchRoatatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {57,58,59,62,63,66,68,72,73,74,75,76,77,78,80,81,86,95,96,97,98,100,101,102,103,110,119,120,121,123,125,
                126,127,132,136,144,145,148,149,151,152,160,161,163,166,168,169,170,173,174,175,178,182,188,189,192,193,196,198,
                199,200,201,202,212,218,219,220,224,225,229,231,232,234,237,238,242,248,249,250,252,253,254,255,257,260,266,268,
                270,273,276,280,281,283,288,290,291,292,294,295,298,299,4,10,13,15,16,17,18,20,22,25,26,27,30,31,34,38,39,40,47,
                53,54};
        SearchRoatatedSortedArray searchRoatatedSortedArray = new SearchRoatatedSortedArray();
        System.out.println(searchRoatatedSortedArray.search(nums, 30));

    }

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int pivot = findPivot(nums, low, high) ;
        System.out.println("pivot "+pivot);
        if(pivot == -1){
            int res = binarySearch(nums, 0 , nums.length-1, target);
            return res;
        }

        int res = binarySearch(nums, 0, pivot, target) == -1
                ? binarySearch(nums, pivot+1, nums.length-1, target)
                : binarySearch(nums, 0, pivot, target);
        return res;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        int mid =  (high + low)/2;
        if(high >= low) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearch(nums, low, mid-1, target);
            } else  {
                return binarySearch(nums, mid+1, high, target);
            }
        }
        return -1;
    }

    private int findPivot(int[] nums, int low, int high){
        if(high < low)
            return -1;
        if(high == low)
            return low;

        int mid =  (high + low)/2;
            if(high > mid && nums[mid] > nums[mid+1]){
                return mid;
            }if(low < mid && nums[mid] < nums[mid-1]){
                return mid-1;
            }if(nums[low] >= nums[mid]){
                return  findPivot(nums, low, mid-1);
             }
            return findPivot(nums, mid+1, high) ;
    }

}
