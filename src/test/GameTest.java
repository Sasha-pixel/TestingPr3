package test;

import game.Game;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void initQuestionsTest() {
        assert Game.getQuestions().size() == 0;
        Game.initQuestions();
        assert Game.getQuestions().size() == 4;
        Game.getQuestions().clear();
    }

    @Test
    public void getUserAnswerTest() {
        InputStream inputStream = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        assertEquals(3, Game.getUserAnswer());
        System.setIn(inputStream);
    }

    @Test
    public void continueOrGetMoneyTest() {
        InputStream inputStream = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        assertFalse(Game.continueOrGetMoney());
        System.setIn(inputStream);
    }

    @Test
    public void checkWrongAnswerTest() {
        Game.initQuestions();
        assertFalse(Game.checkAnswer(Game.getQuestions().get(1), 2, 1));
    }
}