//Ranveer Dhillon

import java.util.Scanner;
public class CarTrivia {

    private String question;
    private String answer;
    private String[] options;
    private static int numberOfQuestions = 0;

    // Constructor for creating a trivia question
    public CarTrivia(String question, String answer, String[] options) {
        this.question = question;
        this.answer = answer;
        this.options = options;
        numberOfQuestions++; // Adds to the the total number of questions
    }

    public CarTrivia() {
        this.question = "";
        this.answer = "";
        this.options = new String[0];
        numberOfQuestions++;
    }

    // Method to handle trivia questions
    public void playTrivia() {
      // Wil be closed in the main.java file
        Scanner scan = new Scanner(System.in);

        // Loop through each trivia question
        for (CarTrivia question : triviaQuestions) {
            // Display the question
            System.out.println(question.getQuestion());
            // Display the multiple choice answers
            question.displayOptions();
            // Ask the user to enter their answer (1, 2, 3)
            System.out.print("Enter your answer (1, 2, 3): ");
            int userChoice = scan.nextInt();
            scan.nextLine();

            // Checks if user input is correct and valid
            if (userChoice >= 1 && userChoice <= question.getOptions().length) {
                String selectedOption = question.getOptions()[userChoice - 1];

                if (question.isCorrectOption(selectedOption)) {
                    // If the answer is correct, inform the user
                    System.out.println("\nCorrect!");
                } else {
                    // If the answer is incorrect, inform the user and display the correct answer
                    System.out.println("Incorrect. The correct answer is: " + question.getAnswer());
                }
            } else {
                // If the input is invalid, inform the user
                System.out.println("Invalid input.");
            }
            System.out.println(" "); // Print an empty line for formatting
        }

        // Display a thank you message
        System.out.println("-------------------");
        System.out.println("Thanks for playing!");
        System.out.println("-------------------");
    }

    // Array of trivia questions
    private static CarTrivia[] triviaQuestions = {
            new CarTrivia("\nWhich car manufacturer produces the Mustang?", "Ford", new String[]{"Ford", "Chevrolet", "Toyota"}),
            new CarTrivia("What does BMW stand for?", "Bayerische Motoren Werke", new String[]{"Bavarian Motor Works", "British Motor Works", "Bayerische Motoren Werke"}),
            new CarTrivia("What does SVJ stand for in Lamborghini?", "Super Veloce Jota", new String[]{"Super Velocity Jet", "Speedy Vehicle Jousting", "Super Veloce Jota"}),
            new CarTrivia("What does ABS stand for in relation to cars?", "Anti-lock braking system", new String[]{"Automatic brake system", "Anti-lock braking system", "Auto body stabilization"}),
            new CarTrivia("Which country is famous for producing the Porsche?", "Germany", new String[]{"Italy", "Germany", "France"}),
            new CarTrivia("What is the best-selling car of all time?", "Toyota Corolla", new String[]{"Volkswagen Beetle", "Ford F-Series", "Toyota Corolla"}),
            new CarTrivia("What car company makes the Model S, Model X, and Model 3?", "Tesla", new String[]{"Tesla", "BMW", "Mercedes-Benz"}),
            new CarTrivia("What is the name of the system that allows a car to start without a key?", "Keyless ignition", new String[]{"Remote start", "Keyless ignition", "Push-button start"})
    };

    // Getter method for the question
    public String getQuestion() {
        return question;
    }

    // Getter method for the correct answer
    public String getAnswer() {
        return answer;
    }

    // Getter method for the options
    public String[] getOptions() {
        return options;
    }

    // Method to display the multiple choice options
    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Method to check if the answer is correct
    public boolean isCorrectOption(String option) {
      // ignores case
        return option.trim().equalsIgnoreCase(answer.trim());
    }

    // Static method to get the total number of questions
    public static int getNumberOfQuestions() {
        return numberOfQuestions;
    }
}
