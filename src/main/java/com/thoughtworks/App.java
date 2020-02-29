package com.thoughtworks;

public class App {

    private String answer;
    private int timesOfGuessing;
    private String currentInput;

    public App() {
    }

    public String getAnswer() {
        return answer;
    }

    public int getTimesOfGuessing() {
        return timesOfGuessing;
    }

    public String getCurrentInput() {
        return currentInput;
    }

    public String generateAnswer() {
        String fileContent = ReadFileUtil.readFile(GuessConstant.ANSWER_PATH);
        if (GuessExamineUtil.inputCheck(fileContent)){
            return fileContent;
        }
        else {
            return new AnswerGenerator().generateRandomAnswer();
        }
    }

    public static void main(String[] args) {
        App guessGame = new App();
    }
}
