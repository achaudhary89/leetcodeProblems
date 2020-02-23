package com.leetcode.practice;

import java.util.*;

public class TopKElements {

    public static void main(String[] args) {
        int k = 3;
        List<Integer> list  =   new ArrayList<>();
        list.add(8);
        list.add(700);
        list.add(80);
        list.add(600);
        list.add(89);
        list.add(800);

 /*        Queue<int[]> queue = gettopKElementsWithIndex(list, k);
        while (!queue.isEmpty()){
            int[] res = queue.poll();
            System.out.println("Mathod 1::key is::"+res[0]+" element is ::"+res[1]);
        }
*/
        Map<Integer, Integer> map = gettopKElementsWithIndexWithMap(list, k);
        Iterator<Map.Entry<Integer, Integer>> entryIterator = map.entrySet().iterator();
        while (k-- >0){
            Map.Entry<Integer, Integer> entry = entryIterator.next();
            System.out.println("Mathod 2::key is::"+entry.getValue()+" element is ::"+entry.getKey());
        }
    }

    private static Map<Integer, Integer> gettopKElementsWithIndexWithMap(List<Integer> list, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0 ; i < list.size() ; i++){
            map.put(list.get(i) ,i);
        }
        return map;
    }

    private static Queue<int[]> gettopKElementsWithIndex(List<Integer> list, int k) {
        int[] keyElements;
         Queue<int[]> priorityQueue = new PriorityQueue(k, new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 return o1[1] -o2[1];
             }
         });

         for (int i = 0; i < list.size() ; i++){
             if(i < k){
                 keyElements = new int[2];
                 keyElements[0]  = i;
                 keyElements[1] =   list.get(i);
                 priorityQueue.add(keyElements);
             }else{
                 if(priorityQueue.peek()[1] < list.get(i)){
                     keyElements = new int[2];
                     keyElements[0]  =i;
                     keyElements[1]  = list.get(i);
                     priorityQueue.poll();
                     priorityQueue.add(keyElements);
                 }
             }

         }
         return priorityQueue;
    }


}
