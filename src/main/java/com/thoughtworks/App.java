package com.thoughtworks;

import java.util.Scanner;

public class App {

    private String answer;
    private int timesOfGuessing;
    private String currentInput;
    private String currentOutput;
    private GuessHistory guessHistory;

    public App() {
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
    }

    private void checkGuess() {
        try {
            if (GuessExamineUtil.inputCheck(currentInput)) {
                currentOutput = GuessExamineUtil.examineGuess(currentInput,answer);
            }
            else {
                throw new WrongFormat();
            }
        } catch (Exception e) {
            currentOutput = "Wrong input";
        }
    }

    private void run(){
        while(timesOfGuessing < GuessConstant.MAX_TIMES_OF_GUESS){
            collectInput();
            checkGuess();
            guessHistory.addToHistory(currentInput,currentOutput);
            if(isCorrect()){
                break;
            }
        }

    }

    public static void main(String[] args) {
        App guessGame = new App();
    }
}
