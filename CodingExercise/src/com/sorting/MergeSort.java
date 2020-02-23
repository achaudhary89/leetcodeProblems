package com.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr   =   {6,9,2,5,1,3};
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(high <= low)
            return;
        int mid = low + (high - low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,mid,low,high);
    }

    private static void merge(int[] arr, int mid, int low, int high) {
        int[] leftArray =   new int[mid-low+1];
        int[] rightArray    =   new int[high-low];

        for(int i = 0 ; i < leftArray.length ; i++){
            leftArray[i]    =   arr[low+i];
        }

        for(int i = 0 ; i < rightArray.length ; i++){
            rightArray[i]    =   arr[mid+i+1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        if(leftIndex < leftArray.length && rightIndex < rightArray.length){

        }
    }
}
