import java.util.Scanner;

public class QuizProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
                "1. Who developed Java Language?\n" +
                        "a) James Gosling\n" +
                        "b) Guido van Rossum\n" +
                        "c) Dennis Ritchie\n" +
                        "d) Charles Babbage\n",

                "2. Which among them is a keyword?\n" +
                        "a) input\n" +
                        "b) output\n" +
                        "c) garbage value\n" +
                        "d) void\n",

                "3. Which of the following is not a primitive data type in Java?\n" +
                        "a) int\n" +
                        "b) float\n" +
                        "c) string\n" +
                        "d) boolean\n",

                "4. What is the correct way to declare a static method in Java?\n" +
                        "a) public void method() {}\n" +
                        "b) static void method() {}\n" +
                        "c) void static method() {}\n" +
                        "d) public static void method() {}\n",

                "5. Which of the following is used to read input from the user in Java?\n" +
                        "a) cin\n" +
                        "b) Console.readLine()\n" +
                        "c) System.in\n" +
                        "d) Scanner\n"
        };

        String[] answers = { "a", "d", "c", "d", "d" };

        do {
            int score = runQuiz(sc, questions, answers);
            System.out.println("Your final score is: " + score + "/" + questions.length);
        } while (retryQuiz(sc));
    }

    private static int runQuiz(Scanner sc, String[] questions, String[] answers) {
        String[] responses = new String[questions.length];
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            responses[i] = getValidResponse(sc);
        }

        for (int i = 0; i < questions.length; i++) {
            if (responses[i].equalsIgnoreCase(answers[i])) {
                score++;
                System.out.println("Question " + (i + 1) + ": Correct!");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect. The correct answer was " + answers[i] + ".");
            }
        }

        return score;
    }

    private static String getValidResponse(Scanner sc) {
        String response;
        while (true) {
            response = sc.next().toLowerCase();
            if (response.equals("a") || response.equals("b") || response.equals("c") || response.equals("d")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a, b, c, or d.");
            }
        }
        return response;
    }

    private static boolean retryQuiz(Scanner sc) {
        System.out.println("Do you want to retry the quiz? (yes/no)");
        while (true) {
            String input = sc.next().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

}
