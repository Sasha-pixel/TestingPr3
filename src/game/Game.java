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
        answering();
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

    public static void answering() {
        for (int i = 1; i < 5; i++) {
            Question question = questions.get(i);
            System.out.println(question.getQuestionText());
            printAnswers(question);
            int answerValue = getUserAnswer();
            if (!checkAnswer(question, answerValue, i)) {
                return;
            }
        }
    }

    public static void printAnswers(Question question) {
        for (Integer key : question.getAnswers().keySet()) {
            System.out.println(key + " - " + question.getAnswers().get(key).getAnswerText());
        }
    }

    public static int getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш вариант ответа: ");
        int answerValue = 0;
        while (answerValue < 1 || answerValue > 4) {
            if (!scanner.hasNextInt()) {
                System.out.print("Некорректный ввод (⊙_⊙)？\nПопробуйте снова: ");
                scanner.next();
            }
            else {
                answerValue = scanner.nextInt();
                if (answerValue < 1 || answerValue > 4) {
                    System.out.print("Некорректный ввод (⊙_⊙)？\nПопробуйте снова: ");
                    answerValue = 0;
                }
            }
        }
        return answerValue;
    }

    public static boolean continueOrGetMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Продолжить игру - 1\tЗабрать деньги - 0");
        int userChoice = -1;
        while (userChoice != 0 && userChoice != 1) {
            if (!scanner.hasNextInt()) {
                System.out.print("Некорректный ввод (⊙_⊙)？\nПопробуйте снова: ");
                scanner.next();
            }
            else {
                userChoice = scanner.nextInt();
                if (userChoice == 1) {
                    System.out.println("Отлично, продолжаем!");
                    return true;
                } else if (userChoice == 0) {
                    System.out.println("Вот ваши деньги. До свидания");
                    return false;
                }
                else {
                    System.out.print("Некорректный ввод (⊙_⊙)？\nПопробуйте снова: ");
                    userChoice = -1;
                }
            }
        }
        return false;
    }

    public static boolean checkAnswer(Question question, int answerValue, int i) {
        if (question.getAnswers().get(answerValue).isRight()) {
            System.out.println("Правильный ответ! Вы заработали " + question.getPrice() + " рублей");
            if (i != 4) {
                if (!continueOrGetMoney())
                    return false;
                else
                    return true;
            }
            else {
                System.out.println("Вы выиграли! Поздравляю ヾ(≧▽≦*)o");
                return false;
            }
        }
        else {
            System.out.println("Неверный ответ! Вы потеряли весь выигрыш (⓿_⓿)");
            return false;
        }
    }
}
