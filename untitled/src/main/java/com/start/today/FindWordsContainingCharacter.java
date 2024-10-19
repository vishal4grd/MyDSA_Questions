package com.start.today;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        char x = 'e';

        System.out.println(findWordsContainingCharacter(words,x));
    }

    private static List<Integer> findWordsContainingCharacter(String[] words, char x) {

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].contains(String.valueOf(x))){
                res.add(i);
            }
        }
        return res;
    }
}
