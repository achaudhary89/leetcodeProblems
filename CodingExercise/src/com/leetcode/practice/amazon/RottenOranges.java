package com.leetcode.practice.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    int days = 0;

    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        RottenOranges rottenOranges = new RottenOranges();
        //System.out.println(rottenOranges.orangesRotting(arr));
        System.out.println(rottenOranges.orangesRottingDFS(arr));
    }

    public int orangesRotting(int[][] grid) {
        int row =   grid.length;
        int column  =   grid[0].length;
        Queue<int[]> rottenOranges  =   new LinkedList<>();
        int[][] adjacent = {{1,0},{-1,0},{0,1},{0,-1}};
        int count_fresh_oranges = 0;
        int res = 0;

        if(row == 0){
            return  res;
        }

        //find rotten oranges and store the indexes in the queue

        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < column ; j++){
                if(grid[i][j] == 2){
                    rottenOranges.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    count_fresh_oranges++;
                }
            }
        }

        if(count_fresh_oranges == 0){
            return res;
        }

        //Apply BFS

        while(rottenOranges.peek() != null){
            ++res;
            int size = rottenOranges.size();

            for (int i = 0; i < size ; i++){
                int[] rotten_orange_location = rottenOranges.poll();
                for (int[] direction : adjacent){
                    int x = rotten_orange_location[0] + direction[0];
                    int y = rotten_orange_location[1] + direction[1];


                    //check  if x and y lie outside the corner or empty then just continue
                    if(x <0 || y < 0 || x >= row || y >= column || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }
                        grid[x][y] = 2;
                        rottenOranges.add(new int[]{x,y});
                        count_fresh_oranges--;

                }

            }

        }

        return  count_fresh_oranges == 0 ? res-1 : -1;
    }

    public int orangesRottingDFS(int[][] grid) {

        int row = grid.length;
        int column  =   grid[0].length;
        int freshCount = 0;
        for(int i = 0; i < row ; i++){
            for (int j = 0; j < column ; j++){
                if(grid[i] [j] == 1){
                    DFS(grid, i,j);
                }
            }
        }
        for(int i = 0; i < row ; i++){
            for (int j = 0; j < column ; j++){
                if(grid[i] [j] == 1){
                    ++freshCount;
                }
            }
        }
        return freshCount == 0 ? days : -1;
    }

    private void DFS(int[][] grid, int x, int y) {

        if(x <0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 ||  grid[x][y] == 2){
            return;
        }
        days++;
        grid[x][y]=2;
        DFS(grid, x+1,y);
        DFS(grid, x,y+1);
        DFS(grid, x-1,y);
        DFS(grid, x,y-1);

    }

}


