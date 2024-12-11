package com.example.mipt_2.utils;

public class TextCounter {
    public static int getCharsCount(String userInput) {
        return userInput.length();
    }

    public static int getWordCount(String userInput){
        return userInput.split("\\s").length;
    }
}
