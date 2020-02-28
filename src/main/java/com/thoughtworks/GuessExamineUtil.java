package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class GuessExamineUtil {

    private static final int GUESS_COUNT = 4;
    private static final int GUESS_LOWER_LIMIT = 1;
    private static final int GUESS_UPPER_LIMIT = 9;


    public static boolean inputCheck(String input) {
        return lengthCheck(input) && rangeCheck(input) && repeatCheck(input);
    }

    private static boolean lengthCheck(String input) {
        return GUESS_COUNT == input.length();
    }

    private static boolean rangeCheck(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) - 48 < GUESS_LOWER_LIMIT) {
                return false;
            }
            if (input.charAt(index) - 48 > GUESS_UPPER_LIMIT) {
                return false;
            }
        }
        return true;
    }

    private static boolean repeatCheck(String input) {
        List<Character> charList = new ArrayList<>();
        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);
            if (charList.contains(currentChar)) {
                return false;
            }
            charList.add(currentChar);
        }
        return true;
    }

    public static String examineGuess(String guess, String answer) {
        int correctIndexCorrectValueCount = 0;
        int wrongIndexCorrectValueCount = 0;

        for (int index = 0; index < guess.length(); index++) {
            char currentGuess = guess.charAt(index);
            CharSequence currentGuessCS = currentGuess + "";
            if (answer.contains(currentGuessCS)) {
                if (answer.indexOf(currentGuess) == index) {
                    correctIndexCorrectValueCount += 1;
                } else
                    wrongIndexCorrectValueCount += 1;
            }
        }
        return correctIndexCorrectValueCount + "A" + wrongIndexCorrectValueCount + "B";
    }

}
