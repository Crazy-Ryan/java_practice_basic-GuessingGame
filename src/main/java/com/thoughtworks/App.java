package com.thoughtworks;

import java.util.Scanner;

public class App {

    private String answer;
    private int timesOfGuessing;
    private String currentInput;
    private String currentOutput;
    private GuessHistory guessHistory;

    public App() {
        timesOfGuessing = 0;
        guessHistory = new GuessHistory();
    }

    private String getAnswer() {
        return answer;
    }

    private int getTimesOfGuessing() {
        return timesOfGuessing;
    }

    private String getCurrentInput() {
        return currentInput;
    }

    private void generateAnswer() {
        String fileContent = ReadFileUtil.readFile(GuessConstant.ANSWER_PATH);
        if (GuessExamineUtil.inputCheck(fileContent)) {
            this.answer = fileContent;
        } else {
            this.answer = new AnswerGenerator().generateRandomAnswer();
        }
    }

    private boolean isCorrect() {
        return GuessExamineUtil.examineGuess(currentInput, this.answer).charAt(0) == GuessConstant.COUNT;
    }

    private void collectInput() {
        Scanner scanner = new Scanner(System.in);
        currentInput = scanner.nextLine();
//        System.out.println(currentInput);
    }

    private void checkGuess() {
        try {
            if (GuessExamineUtil.inputCheck(currentInput)) {
                timesOfGuessing++;
                currentOutput = GuessExamineUtil.examineGuess(currentInput, answer);
            } else {
                throw new WrongFormatException();
            }
        } catch (WrongFormatException e) {
            currentOutput = "Wrong input";
        }
    }

    public void run() {
        generateAnswer();
        System.out.println("Please input your guess");
        while (timesOfGuessing < GuessConstant.MAX_TIMES_OF_GUESS) {
            collectInput();
            checkGuess();
            guessHistory.addToHistory(currentInput, currentOutput);
            if (isCorrect()) {
                break;
            }
            System.out.println(guessHistory);
        }
    }

    public static void main(String[] args) {
        App guessGame = new App();
        guessGame.run();
    }
}
