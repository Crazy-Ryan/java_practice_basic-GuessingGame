package com.thoughtworks;

import java.util.Random;

public class AnswerGenerator implements Answer {
    private String answer;

    public AnswerGenerator() {
    }

    public AnswerGenerator(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public void generateRandomAnswer() {
        Random random = new Random();
        StringBuilder ans = new StringBuilder();
        for (int index = 0; index < GuessConstant.COUNT; index++) {
            ans.append(GuessConstant.LOWER_LIMIT
                    + random.nextInt(GuessConstant.UPPER_LIMIT - GuessConstant.LOWER_LIMIT + 1));
        }
        this.answer = ans.toString();
    }
}
