import java.util.Scanner;

public class Quiz_Game {

    public static void main(String[] args) {
        String[][] questions = {
            {"Which of the following is not a Java keyword?", "static", "Boolean", "void", "private", "B"},
            {"What is the size of int in Java?", "4 bytes", "8 bytes", "2 bytes", "Depends on the system", "A"},
            {"Which method must be implemented by all threads?", "start()", "stop()", "run()", "main()", "C"},
            {"What is the default value of a boolean variable in Java?", "true", "false", "null", "0", "B"},
            {"Which of these are selection statements in Java?", "break", "continue", "for()", "if()", "D"},
            {"Which package contains the Random class?", "java.util package", "java.lang package", "java.io package", "java.net package", "A"},
            {"Which of these keywords is used to define interfaces in Java?", "interface", "Interface", "intf", "Intf", "A"},
            {"Which of these cannot be used for a variable name in Java?", "identifier", "keyword", "variable", "method", "B"},
            {"Which of these operators is used to allocate memory to an object?", "malloc", "alloc", "new", "calloc", "C"},
            {"Which of these access specifiers can be used for an interface?", "public", "protected", "private", "All of the above", "A"},
            {"Which method can be used to find the length of a string in Java?", "length()", "size()", "getLength()", "Lengthof()", "A"},
            {"Which of the following is not an OOP concept in Java?", "Inheritance", "Encapsulation", "Polymorphism", "Compilation", "D"},
            {"Which of these is the correct way to inherit a class in Java?", "class A extends B {}", "class A inherits B {}", "class A extends B () {}", "class A extends B {}", "A"},
            {"Which of these keywords is used to refer to current object?", "import", "this", "catch", "abstract", "B"},
            {"What is the return type of the hashCode() method in the Object class?", "int", "Object", "void", "long", "A"}
        };

        playQuiz(questions);
    }

    public static void playQuiz(String[][] questions) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Java Quiz Game!");
        System.out.println("You will be asked 15 questions. Each correct answer gives you 1 point.");
        System.out.println("Let's start!");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i][0]);
            System.out.println("A. " + questions[i][1]);
            System.out.println("B. " + questions[i][2]);
            System.out.println("C. " + questions[i][3]);
            System.out.println("D. " + questions[i][4]);

            System.out.print("Enter your answer (A, B, C, D): ");
            String answer = scanner.nextLine().toUpperCase();

            if (answer.equals(questions[i][5])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + questions[i][5] + ". " + questions[i][getIndex(questions[i][5])]);
            }
        }

        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is: " + score + " out of " + questions.length);

        if (score == questions.length) {
            System.out.println("Congratulations! You got all answers right!");
        } else if (score >= questions.length / 2) {
            System.out.println("Good job! You scored above average.");
        } else {
            System.out.println("Better luck next time!");
        }

        scanner.close();
    }

    public static int getIndex(String option) {
        switch (option) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            default:
                return -1;
        }
    }
}
