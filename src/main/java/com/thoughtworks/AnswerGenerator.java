package com.thoughtworks;

import java.util.Random;

public class AnswerGenerator implements Answer {

    @Override
    public String generateRandomAnswer() {
        Random random = new Random();
        StringBuilder ans = new StringBuilder();
        for (int index = 0; index < GuessConstant.COUNT; index++) {
            ans.append(GuessConstant.LOWER_LIMIT
                    + random.nextInt(GuessConstant.UPPER_LIMIT - GuessConstant.LOWER_LIMIT + 1));
        }
        return ans.toString();
    }
}
