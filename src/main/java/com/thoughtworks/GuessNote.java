package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class GuessNote {
    private int inputCount;
    private List<String> inputHistory;
    private List<String> outputHistory;

    public GuessNote() {
        inputHistory = new ArrayList<>();
        outputHistory = new ArrayList<>();
    }

    public int getInputCount() {
        return inputCount;
    }

    public List<String> getInputHistory() {
        return inputHistory;
    }

    public List<String> getOutputHistory() {
        return outputHistory;
    }

    public boolean inputCheck(String input) {
        return lengthCheck(input) && rangeCheck(input) && repeatCheck(input);
    }

    private boolean lengthCheck(String input) {
        return 4 == input.length();
    }

    private boolean rangeCheck(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) < '1') {
                return false;
            }
            if (input.charAt(index) > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean repeatCheck(String input) {
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

    public void addToInputHistory(String input) {
        inputHistory.add(input);
    }

    public void addToOutputHistory(String output) {
        outputHistory.add(output);
    }

}
