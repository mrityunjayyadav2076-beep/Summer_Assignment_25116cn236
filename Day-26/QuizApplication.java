import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isAnswerCorrect(int userChoice) {
        return userChoice == (correctAnswerIndex + 1);
    }
}

class QuizEngine {
    private List<Question> questions;
    private int score;

    public QuizEngine() {
        this.questions = new ArrayList<>();
        this.score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
            "Which component is used to compile, debug, and execute the Java program?",
            new String[]{"JRE", "JIT", "JDK", "JVM"},
            2 // JDK is correct
        ));

        questions.add(new Question(
            "Which of these is not a primitive data type in Java?",
            new String[]{"int", "Float", "boolean", "char"},
            1 // Float (Wrapper Class) is correct
        ));

        questions.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            new String[]{"implements", "extends", "inherits", "import"},
            1 // extends is correct
        ));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        score = 0;

        System.out.println("=========================================");
        System.out.println("     WELCOME TO THE JAVA QUIZ SYSTEM     ");
        System.out.println("=========================================\n");

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());
            
            String[] options = currentQuestion.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println("  " + (j + 1) + ") " + options[j]);
            }

            int userChoice = -1;
            while (true) {
                System.out.print("Your answer (Enter option number 1-" + options.length + "): ");
                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                    if (userChoice >= 1 && userChoice <= options.length) {
                        break;
                    }
                } else {
                    scanner.next(); 
                }
                System.out.println("Invalid entry. Please choose a valid index number.");
            }

            // Evaluation block
            if (currentQuestion.isAnswerCorrect(userChoice)) {
                System.out.println("✨ Correct Answer!\n");
                score++;
            } else {
                int correctIdx = currentQuestion.getCorrectAnswerIndex();
                System.out.println("❌ Wrong! Correct answer was: " + (correctIdx + 1) + ") " + options[correctIdx] + "\n");
            }
        }


        displayResults();
        scanner.close();
    }

    private void displayResults() {
        System.out.println("=========================================");
        System.out.println("               QUIZ OVER                 ");
        System.out.println("=========================================");
        System.out.println("Your Final Score: " + score + " / " + questions.size());
        double percentage = ((double) score / questions.size()) * 100;
        System.out.printf("Success Percentage: %.2f%%\n", percentage);
        System.out.println("=========================================");
    }
}


public class QuizApplication {
    public static void main(String[] args) {
        QuizEngine quiz = new QuizEngine();
        quiz.startQuiz();
    }
}
