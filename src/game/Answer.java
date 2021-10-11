package game;

public class Answer {

    private String answerText;

    private boolean isRight;

    public Answer(String answerText, boolean isRight) {
        this.answerText = answerText;
        this.isRight = isRight;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isRight() {
        return isRight;
    }
}
