package com.multithreading.udemy.example.join;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiThreadedFactorial {

    public static void main(String[] args) {

        List<Long> inputNumbers = Arrays.asList(343l, 476l,899l,87l,34343l);

        List<FactorialThread> factorialThreads   =   new ArrayList<>();
        for(long number : inputNumbers){
            factorialThreads.add(new FactorialThread(number));
        }

        for(Thread thread : factorialThreads){
            thread.start();
        }

        for(Thread thread : factorialThreads){
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }
        for (int i = 0 ; i < inputNumbers.size() ; i++){
            FactorialThread factorialThread =   factorialThreads.get(i);
            if(factorialThread.isCompleted){
                System.out.println("Factorial of number:: "+inputNumbers.get(i) +"is:: "+factorialThread.getResult());
            }else{
                System.out.println("The calculation of "+inputNumbers.get(i)+" is in progress");
            }

        }

    }

    private static class FactorialThread extends Thread{
        private long number;
        private BigInteger result;
        private boolean  isCompleted = false;

        FactorialThread(long number){
            this.number =   number;
        }

        @Override
        public void run(){
            this.result  =   factorial(number);
            this.isCompleted = true;
        }

        public BigInteger factorial(long n){
            BigInteger tmpResult    =   BigInteger.ONE;
            for(long i = n ; i > 0 ; i-- ){
                tmpResult = tmpResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tmpResult;
        }

        public Boolean getCompleted() {
            return isCompleted;
        }

        public void setCompleted(Boolean completed) {
            isCompleted = completed;
        }

        public BigInteger getResult(){
            return result;
        }
    }
}


