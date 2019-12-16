package com.leetcode.practice.fav;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        String s = "";

        int[][] input =  {{2,3},{1,4}};
        MergeIntervals mergeIntervals   =   new MergeIntervals();
        int[][] res = mergeIntervals.merge(input);
        for(int[] r : res){
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return 0;
                if(o1[0] < o2[0])
                    return -1;
                else
                    return 1;
            }
        });
        return mergeIntervalRecursively(intervals,0);

    }

    public int[] [] mergeIntervalRecursively(int[][] intervals, int index){
        if(intervals.length <= 1){
            return intervals;
        }
        if(index >= intervals.length-1){
            return intervals;
        }

        if(intervals[index][0] <= intervals[index+1][0] && intervals[index][1] <= intervals[index+1][1]
        && intervals[index][1] >= intervals[index+1][0]
        ){
            int[] [] newInterval    =   new int[intervals.length-1][2];
            newInterval[index][0] = intervals[index][0];
            newInterval[index][1] = intervals[index+1][1];
            System.arraycopy(intervals, 0,newInterval,0,index);
            System.arraycopy(intervals, index+2,newInterval,index+1,intervals.length-index-2);
            return mergeIntervalRecursively(newInterval, index);
        }

        if(intervals[index][0] <= intervals[index+1][0] && intervals[index][1] >= intervals[index+1][1]){
            int[] [] newInterval    =   new int[intervals.length-1][2];
            newInterval[index][0] = intervals[index][0];
            newInterval[index][1] = intervals[index][1];
            System.arraycopy(intervals, 0,newInterval,0,index);
            System.arraycopy(intervals, index+2,newInterval,index+1,intervals.length-index-2);
            return mergeIntervalRecursively(newInterval, index);
        }

        return mergeIntervalRecursively(intervals, ++index);
    }
}
