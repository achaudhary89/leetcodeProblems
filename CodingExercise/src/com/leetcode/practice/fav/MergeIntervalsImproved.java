package com.leetcode.practice.fav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsImproved {
    public static void main(String[] args) {
        int[][] input = {{2, 3}, {1, 4}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] res = mergeIntervals.merge(input);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }


    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] newInterval = intervals[0];
        res.add(intervals[0]);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                //overlapping case, move interval if necessary
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}