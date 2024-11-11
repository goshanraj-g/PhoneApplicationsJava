import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    //instantiating the scanner, and classes
    //initializing variables and calculator and tracker object
    Scanner scan = new Scanner(System.in);
    FoodTracker tracker = new FoodTracker();
    Calculator calc = new Calculator();
    String useAgain = "Y";
    int option = -1;
    String turnOffPhone = "N";

    System.out.println("Your phone has been turned on.");
    
    //loop to keep the program running until the user wants to turn it off
    while (true) {
      if (turnOffPhone.equalsIgnoreCase("Y")) {
        System.out.println("Powering off...");
        break;
      }
      
    //asks user for which app they want to use
      System.out.println("Which app would you like to use? (1, 2, 3, 4) ");
      System.out.println("1. Calculator");
      System.out.println("2. Car Trivia");
      System.out.println("3. Fitness Tracker");
      System.out.println("4. Food Tracker");

      int selection = scan.nextInt();
      scan.nextLine();
      while (selection < 0 && selection > 4) {
        System.out.println("Enter a valid option: (1, 2, 3, or 4)");
        useAgain = scan.nextLine();
      }

//depending on which app they select, it will select one of these four switch statements which correspond to an app
      switch (selection) {
        case 1:
          useAgain = "Y";
          System.out.println("\nOpening Calculator...");
          while (true) {

// if the user does not want to play again, the program will break.
            if (useAgain.equals("N")) {
              break;
            }

            System.out.println(
                "Welcome to the Calculator App!\nWould you rather do a Calculation or Quadratic Factoring? (1 -> Calculator, 2 -> Quadratic Factoring)");
            option = scan.nextInt();
            scan.nextLine();

            while (option < 1 || option > 2) {
              System.out.println("Enter a valid option: (1 -> Calculator, 2 -> Quadratic Factoring)");
              option = scan.nextInt();
              scan.nextLine();
              
// depending on the user's input, the program will run the calculator with two or three inputs. Option 1 = 2 inputs, Option 2 = 3 inputs.
            }

            if (option == 2) {
              
              // setting inputs
              calc = new Calculator(0, 0, 0);
              calc.setInputOne();
              calc.setInputTwo();
              calc.setInputThree();
              
            } else {
              
              // setting inputs
              calc = new Calculator(0, 0);
              calc.setInputOne();
              calc.setInputTwo();
            }

            calc.calculate();
            
// running the calculator. Methods are compiled in the class.
            System.out.println("Would you like to use it again? (Yes -> Y, No -> N)");
            useAgain = scan.nextLine();
            while (!useAgain.equals("Y") && !useAgain.equals("N")) {
              System.out.println("Enter a valid option: (Yes -> Y, No -> N)");
              useAgain = scan.nextLine();
            }
            
// user input for running the program again or not
            System.out.println();
          }
          break;
          
        case 2:
          System.out.println("\nOpening Car Trivia...");
          System.out.println("\nOpening Car Trivia...");
          CarTrivia trivia = new CarTrivia();
          trivia.playTrivia();
          break;
        case 3:
          System.out.println("\nOpening Fitness Tracker...");
          
// Fitness tracker selection menu
          FitnessApp exercise1 = new FitnessApp("Squats", 10, 15);
          FitnessApp exercise2 = new FitnessApp("Push Ups", 10, 20);
          FitnessApp exercise3 = new FitnessApp("Jump Rope", 5, 60);
          FitnessApp exercise4 = new FitnessApp("Running on the spot", 10, 30);

// User chooses exercise
          System.out.println("Please choose an exercise:");
          System.out.println("1. " + exercise1.getName());
          System.out.println("2. " + exercise2.getName());
          System.out.println("3. " + exercise3.getName());
          System.out.println("4. " + exercise4.getName());

          System.out.print("Enter your choice of workout (1-4): ");
          int choice = scan.nextInt();
          scan.nextLine();

          switch (choice) {
            case 1:
              exercise1.doExercise();
              break;
            case 2:
              exercise2.doExercise();
              break;
            case 3:
              exercise3.doExercise();
              break;
            case 4:
              exercise4.doExercise();
              break;
            default:
              System.out.println("Invalid option selected.");
          }

          exercise1.rest();
          exercise2.rest();
          exercise3.rest();
          exercise4.rest();

          exercise1.coolDown();
          exercise2.coolDown();
          exercise3.coolDown();
          exercise4.coolDown();
          break;
          
        case 4:
          System.out.println("\nOpening Food Tracker...");
          
//runs the tracker class
          tracker.track();
          break;
      }
      System.out.println();
      
//asks the user if they want to turn off the phone
      System.out.println("Would you like to turn off the phone? Otherwise, continue using apps. (Yes -> Y, No -> N)");
      turnOffPhone = scan.nextLine();
      while (!turnOffPhone.equals("Y")&&!turnOffPhone.equals("N")) {
        System.out.println("Enter a valid input: (Yes -> Y, No -> N) ");
        turnOffPhone = scan.nextLine();
      }
    }
  
//closes scanner object
    scan.close();
  }
}