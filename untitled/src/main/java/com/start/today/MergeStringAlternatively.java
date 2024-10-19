package com.start.today;

public class MergeStringAlternatively {
    public static void main(String[] args) {
        String word1 = "abcde";
        String word2 = "pqr";

        String result = mergeStringAlternative(word1,word2);
        System.out.println(result);
    }

    private static String mergeStringAlternative(String word1, String word2) {

        StringBuilder result = new StringBuilder();
        int i=0;
        while(i<word1.length() || i<word2.length()){
            if(i<word1.length()){
                result.append(word1.charAt(i));
            }
            if(i<word2.length()){
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}
