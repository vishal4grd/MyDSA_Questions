package today.common;

public class SwapTwoString {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "World";

        System.out.println("before swapping : a =  " + a + " and b = " + b);

        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a= a.substring(b.length());
        System.out.println("After swapping : a =  " + a + " and b = " + b);

    }
}
