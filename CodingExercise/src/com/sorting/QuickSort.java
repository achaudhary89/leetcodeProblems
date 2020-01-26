package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr   =   {6,9,2,5,1,3};
        quickSort(arr,0,5);
        Arrays.stream(arr).boxed().collect(Collectors.toList());
        Arrays.stream(arr).forEach(e -> System.out.println(e));

    }

    public static void quickSort(int[] arr, int left, int right){

        int pivot = left + (right-left)/2;
        int pivotValue  =   arr[pivot];
        int i = left;
        int j = right;

        while (i <= j){
            while (arr[i] < pivotValue){
                i++;
            }
            while (arr[j] > pivotValue){
                j--;
            }

            if(i <= j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }

            if(left < j){
                quickSort(arr,left,j);
            }

            if(right > i){
                quickSort(arr, i, right);
            }
        }


    }
}
