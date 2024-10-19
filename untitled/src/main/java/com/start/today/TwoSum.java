package com.start.today;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = {3,2,4};
        int target = 6;
        int[] result = checkTwoSum(arr,target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] checkTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int req_num = target-arr[i];
            if(hm.containsKey(req_num)){
                int[] res = {hm.get(req_num),i};
                return res;
            }
            hm.put(arr[i],i);

        }
        return null;
    }
}
