package game;

import java.util.Map;

public class Question {

    private String questionText;

    private Map<Integer, Answer> answers;

    private int price;

    public Question(String questionText, Map<Integer, Answer> answers, int price) {
        this.questionText = questionText;
        this.answers = answers;
        this.price = price;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public int getPrice() {
        return price;
    }
}
