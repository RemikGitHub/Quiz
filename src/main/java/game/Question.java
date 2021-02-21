package game;

public class Question {

    private final String question;
    private final String answerA;
    private final String answerB;
    private final String answerC;
    private final String answerD;
    private final char rightAnswer;

    public Question() {
        this.question = null;
        this.answerA = null;
        this.answerB = null;
        this.answerC = null;
        this.answerD = null;
        this.rightAnswer = ' ';
    }

    public Question(String question, String answerA, String answerB, String answerC, String answerD, char rightAnswer) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public char getRightAnswer() {
        return rightAnswer;
    }
}
