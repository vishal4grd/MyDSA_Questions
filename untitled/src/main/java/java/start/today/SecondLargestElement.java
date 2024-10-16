package java.start.today;

public class SecondLargestElement {
    public static void main(String[] args) {

        int[] arr = {2,3,7,11,77};
        int n = arr.length;
        int secondLargestArray = print2largest(arr,n);
        System.out.println(secondLargestArray);
    }

    private static int print2largest(int[] arr, int n) {
        int largest = arr[0];
        int secondLargest = -1;

        for(int i=1; i<n;i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]> secondLargest && arr[i] < largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }


}
