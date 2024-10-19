package com.start.today.common;

public class FindPairsInArray {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 12;
        getPairsCount(arr, sum);
    }

    private static void getPairsCount(int[] arr, int sum) {
        for(int i =0;i<arr.length;i++){
            for(int j= i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == sum){
//                    System.out.println(" pair Count is "+ arr[i] + arr[j]);
                    System.out.printf("(%d, %d) %n", arr[i],arr[j]);
                }
            }
        }
    }
}
