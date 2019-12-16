package com.leetcode.practice;

class Dungeon {
    public int calculateMinimumHP(int[][] dungen) {

        int[][] dp = new int[dungen.length][dungen[0].length];
        int[][] dp_extra_power  =   new int[dungen.length][dungen[0].length];

        dp[0][0] = dungen[0][0] <= 0 ? Math.abs(dungen[0][0] )+ 1 : 0;
        dp_extra_power[0][0] = dungen[0][0] > 0 ? dungen[0][0] : 0;

        for (int i = 1 ; i < dungen.length ; i++){
                dp[i][0] = dungen[i][0] < 0 ? dp[i - 1][0] + Math.abs(dungen[i][0]) : dp[i-1][0];
                dp_extra_power[i][0] = dungen[i][0] > 0 ? dp_extra_power[i-1][0]+dungen[i][0] : dp_extra_power[i-1][0];
        }

        for (int i = 1 ; i < dungen[0].length ; i++){
            dp[0][i] = dungen[0][i] < 0 ? dp[0][i-1] + Math.abs(dungen[0][i]) : dp[0][i-1];
            dp_extra_power[0][i] = dungen[0][i] > 0 ? dp_extra_power[0][i-1]+dungen[0][i] : dp_extra_power[0][i-1];

        }

        for (int i = 1 ; i < dungen.length ; i++){

            for (int j = 1 ; j < dungen[0].length ; j ++) {

                if(dungen[i][j]<0) {

                   dp[i][j] =  Math.min(dp[i - 1][j], dp[i][j - 1]) + Math.abs(dungen[i][j]);
                   dp_extra_power[i][j] = dp[i-1][j] < dp[i][j-1] ? dp_extra_power[i-1][j] : dp_extra_power[i][j-1];
                   // :Math.min(dp[i - 1][j], dp[i][j - 1]);
                }else{
                    dp[i][j] =  Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp_extra_power[i][j] = dp[i-1][j] < dp[i][j-1] ? dp_extra_power[i-1][j]+dungen[i][j] : dp_extra_power[i][j-1]+dungen[i][j];

                }
            }
        }

        return dp[dungen.length-1][dungen[0].length -1]-dp_extra_power[dungen.length-1][dungen[0].length -1];
    }

    public static void main (String args[]){

        int[][] test =  {{0}};//{{-2,-3,3},{-5,-10,1},{10,30,-5}};

        Dungeon dungeon = new Dungeon();
        System.out.println(dungeon.calculateMinimumHP(test));

    }
}
