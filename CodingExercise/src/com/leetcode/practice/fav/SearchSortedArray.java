package com.leetcode.practice.fav;

public class SearchSortedArray {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8,8,8};
        SearchSortedArray searchSortedArray =   new SearchSortedArray();
        System.out.println(searchSortedArray.searchRange(nums, 8));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        if(nums.length == 0){
            return res;
        }

        if(nums.length == 1 && nums[0] == target){
            res[0] = 0;
            res[1] = 0;
            return res;
        }

        if(nums.length == 1 && nums[0] != target){
            return res;
        }
        int l = 0;
        int h = nums.length -1;
        int highIndex;
        int highIndexPrevious = -1;
        int lowIndex;
        int lowIndexPrevious = -1;

        highIndex   =   search(nums, l, h, target);
        lowIndex    =   highIndex;
        while(highIndex != -1){
            highIndexPrevious = highIndex;
            highIndex = search(nums, highIndex+1, h, target);
        }

        while (lowIndex != -1){
            lowIndexPrevious = lowIndex;
            lowIndex = search(nums, 0, lowIndex-1, target);
        }
        //System.out.println(lowIndexPrevious);
        //System.out.println(highIndexPrevious);
        res[0] = lowIndexPrevious;
        res[1] = highIndexPrevious;
        return res;
    }

    public int search(int[] nums, int l, int h, int target){
        int mid = (l+h)/2;
        if(h >= l) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return search(nums, l, mid - 1, target);
            } else {
                return search(nums, mid + 1, h, target);
            }
        }

        return -1;
    }
}
