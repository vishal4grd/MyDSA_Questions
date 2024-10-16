package java.start.today;

import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,1,4,2,3,5,7,8,9};
        int[] arr = {1,2,3,9,9};

        boolean ans = removeDuplicate(arr);
        System.out.println(ans);
    }

    private static boolean removeDuplicate(int[] arr) {
        HashSet<Integer> res = new HashSet<>();
        for(int num: arr){
            if(res.contains(num)) return true;
            res.add(num);
        }
        return false;

    }

}


