package com.start.today.common;

public class UppertoLowerCase {
    public static void main(String[] args) {
        String str = "HELLO WORLD";
        tooLowerCase(str);
    }

    private static void tooLowerCase(String str) {
        for(int i=0;i<str.length();i++){
            char character = str.charAt(i);

            if( 65 <= character && character <=90){
                character = (char) ((character + 32));
            }
            System.out.print(character);
        }
    }
}
