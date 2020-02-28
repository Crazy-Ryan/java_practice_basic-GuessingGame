package com.thoughtworks;

import jdk.internal.util.xml.impl.Input;

import java.util.List;

public class GuessNote {
    private int inputCount;
    private List<String> inputHistory;
    private List<String> outputHistory;

    public GuessNote() {
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

}
