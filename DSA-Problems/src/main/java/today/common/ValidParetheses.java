package today.common;

public class ValidParetheses {
    public static void main(String[] args) {
        // Input: nums = [-1,0,3,5,9,12], target = 9

        /*int[] arr = {0, 1, 2, 3, 5};
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(i)) {
                System.out.println("missing number is : " + i);
                break;
            }
        }*/
        int[] arr = {0, 1, 2, 3, 5};
        int n = arr.length;
        int sum = 0;
        int totalsum = n *(n+1)/2;
        for(int num : arr){
            sum += num;
        }
        int result = totalsum - sum;

        System.out.println("Missing number is : " + result);
    }
}
