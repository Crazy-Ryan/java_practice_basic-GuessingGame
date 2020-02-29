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

    public void generateAnswer() {
        String fileContent = ReadFileUtil.readFile(GuessConstant.ANSWER_PATH);
        if (GuessExamineUtil.inputCheck(fileContent)) {
            this.answer = fileContent;
        } else {
            this.answer = new AnswerGenerator().generateRandomAnswer();
        }
    }

    public boolean isCorrect(){
        return GuessExamineUtil.examineGuess(currentInput,this.answer).charAt(0) == GuessConstant.COUNT;
    }

    public static void main(String[] args) {
        App guessGame = new App();
    }
}
