package com.start.today.common;

public class DuplicateWord {
    public static void main(String[] args) {
        String string = "Big black bug bit a big black dog on his big black nose";
        int count;

        string= string.toLowerCase();
        String[] word = string.split(" ");
        for(int i=0;i<word.length;i++){
            count =0;
            for(int j=i+1;j<word.length;j++){
                if(word[i].equals(word[j])){
                    count++;
                    word[j] = "0";
                }
            }
            if(count >1 && word[i] != "0"){
                System.out.println(word[i]);
            }
        }
    }
}
