package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class GuessHistory {
    private int inputCount;
    private List<String> inputHistory;
    private List<String> outputHistory;

    public GuessHistory() {
        inputCount = 0;
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

    public void addToHistory(String input, String output) {
        inputHistory.add(input);
        outputHistory.add(output);
        inputCount += 1;
    }

}
