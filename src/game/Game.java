package game;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private static Map<Integer, Question> questions = new HashMap<>();

    public static Map<Integer, Question> getQuestions() {
        return questions;
    }

    public static void runGame() {
        initQuestions();
        startOutput();
    }

    public static void startOutput() {
        System.out.println("Дано 4 вопроса. Отвечая на каждый вопрос, вы увеличиваете сумму выигрыша.\n50.000 > 100.000 > 200.000 > 400.000\nИгра началась!");
    }

    public static void initQuestions() {
        Map<Integer, Answer> answersForQuestion1 = new HashMap<>();
        answersForQuestion1.put(1, new Answer("1983", false));
        answersForQuestion1.put(2, new Answer("1991", false));
        answersForQuestion1.put(3, new Answer("1984", true));
        answersForQuestion1.put(4, new Answer("1987", false));
        Question question1 = new Question("В каком году была снята первая часть серии «Терминатор»?", answersForQuestion1, 50000);
        questions.put(1, question1);

        Map<Integer, Answer> answersForQuestion2 = new HashMap<>();
        answersForQuestion2.put(1, new Answer("Мак-Кинли", false));
        answersForQuestion2.put(2, new Answer("Денали", true));
        answersForQuestion2.put(3, new Answer("Броуд-Пик", false));
        answersForQuestion2.put(4, new Answer("Рашмор", false));
        Question question2 = new Question("Какая гора является самой высокой в Северной Америке?", answersForQuestion2, 100000);
        questions.put(2, question2);

        Map<Integer, Answer> answersForQuestion3 = new HashMap<>();
        answersForQuestion3.put(1, new Answer("Кислород", true));
        answersForQuestion3.put(2, new Answer("Кальций", false));
        answersForQuestion3.put(3, new Answer("Углерод", false));
        answersForQuestion3.put(4, new Answer("Железо", false));
        Question question3 = new Question("Какой химический элемент составляет более половины массы тела человека?", answersForQuestion3, 200000);
        questions.put(3, question3);

        Map<Integer, Answer> answersForQuestion4 = new HashMap<>();
        answersForQuestion4.put(1, new Answer("Стадо овец", false));
        answersForQuestion4.put(2, new Answer("Город", false));
        answersForQuestion4.put(3, new Answer("Пейзаж", true));
        answersForQuestion4.put(4, new Answer("Драпировка", false));
        Question question4 = new Question("Что изображено на заднем плане картины Леонардо да Винчи «Мона Лиза»?", answersForQuestion4, 400000);
        questions.put(4, question4);
    }


}
