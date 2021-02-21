package game;

import json.JsonReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final String easyQuestionsPath = ".\\questions\\easy.json";
    private final String mediumQuestionsPath = ".\\questions\\medium.json";
    private final String hardQuestionsPath = ".\\questions\\hard.json";

    private final int easyRounds = 3;
    private final int mediumRounds = 2;
    private final int hardRounds = 1;
    private final int allRounds = (easyRounds + mediumRounds + hardRounds);

    private final int pointsForEasy = 1;
    private final int pointsForMedium = 2;
    private final int pointsForHard = 3;

    private List<Question> easyQuestions;
    private final List<Question> mediumQuestions;
    private final List<Question> hardQuestions;

    private Player player;

    private int roundNumber;

    private final Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);

        this.roundNumber = 1;
        this.easyQuestions = new ArrayList<Question>(JsonReader.getQuestionListFromJson(easyQuestionsPath));
        this.mediumQuestions = new ArrayList<Question>(JsonReader.getQuestionListFromJson(mediumQuestionsPath));
        this.hardQuestions = new ArrayList<Question>(JsonReader.getQuestionListFromJson(hardQuestionsPath));
    }

    public void startTheGame() {

        hello();

        while (roundNumber <= allRounds) {

            if (roundNumber <= easyRounds) {

                System.out.println("-Easy level-\n");
                if (askPlayer(easyQuestions)) player.givePoints(pointsForEasy);

            } else if (roundNumber <= (easyRounds + mediumRounds)) {

                System.out.println("-Medium level-\n");
                if (askPlayer(mediumQuestions)) player.givePoints(pointsForMedium);

            } else {

                System.out.println("-Hard level-\n");
                if (askPlayer(hardQuestions)) player.givePoints(pointsForHard);

            }

            ++roundNumber;
        }

        System.out.println(player.getName() + "! This is your score: " + player.getPoints());

        scanner.close();
    }

    private void hello() {
        System.out.println("Quiz game\n");
        player = makePlayer();
        System.out.println("\n" + player.getName() + "! Answer the questions.\n");
    }

    private Player makePlayer() {
        System.out.print("Write your name: ");
        String name = scanner.nextLine();
        return new Player(name);
    }

    private boolean askPlayer(List<Question> questions) {

        int randomIndex = getRandomIndex(questions.size() - 1);

        System.out.println(roundNumber + ". " + questions.get(randomIndex).getQuestion());
        System.out.println("A." + questions.get(randomIndex).getAnswerA());
        System.out.println("B." + questions.get(randomIndex).getAnswerB());
        System.out.println("C." + questions.get(randomIndex).getAnswerC());
        System.out.println("D." + questions.get(randomIndex).getAnswerD());

        char answer = getAnswer();

        boolean isCorrect = answer == questions.get(randomIndex).getRightAnswer();

        questions.remove(randomIndex);

        return isCorrect;

    }

    private char getAnswer() {

        char answer;

        do {
            System.out.print("Write your answer: ");
            answer = scanner.next().charAt(0);
            answer = Character.toLowerCase(answer);
        } while (answer != 'a' && answer != 'b' && answer != 'c' && answer != 'd');

        return answer;
    }

    private int getRandomIndex(int max) {
        return (int) ((Math.random() * (max + 1)));
    }
}
