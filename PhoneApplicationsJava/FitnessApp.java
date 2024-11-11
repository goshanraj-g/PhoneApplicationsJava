//Adebola Adesina

import java.util.Scanner;
// Starts the Fitness class
class FitnessApp {
    // Storing each name of the exercises
    private String name;
    private int duration;
    private int reps;
    private String equipment;

    // Defines a constructor and initalizes all variables to default values 
    public FitnessApp() {
        this.name = "";
        this.duration = 0;
        this.reps = 0;
        this.equipment = "";
    }
    // This line takes the 4 objects and initializes the corresponding variables
    public FitnessApp(String name, int duration, int reps, String equipment) {
        this.name = name;
        this.duration = duration;
        this.reps = reps;
        this.equipment = equipment;
    }

    // Using the overloaded constructors to initialize the exercises
    public FitnessApp(String name) {
        this.name = name;
        this.duration = 0;
        this.reps = 0;
        this.equipment = "";
    }

    public FitnessApp(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.reps = 0;
        this.equipment = "";
    }

    public FitnessApp(String name, int duration, int reps) {
        this.name = name;
        this.duration = duration;
        this.reps = reps;
        this.equipment = "";
    }

    public FitnessApp(String name, int duration, String equipment) {
        this.name = name;
        this.duration = duration;
        this.reps = 0;
        this.equipment = equipment;
    }

    // Using getter methods to retrieve the values and setter mode to set them
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    // Prints out the exercise to be perfomed as well as the duration and reps 
    public void doExercise() {
        System.out.println("Perform " + name + " for  " + duration + " minutes (As many minutes you need) and do " + reps + " reps.");
    }

    public void rest() {
        System.out.println("Rest for 1-2 minutes.");
    }

    public void coolDown() {
        System.out.println("Cooling down...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Creating 4 exercises with different parameters and reps 
        FitnessApp exercise1 = new FitnessApp("Squats", 10, 15);
        FitnessApp exercise2 = new FitnessApp("Push Ups", 10, 20);
        FitnessApp exercise3 = new FitnessApp("Jump Rope", 5, 60);
        FitnessApp exercise4 = new FitnessApp("Running on the spot", 10, 30);

        System.out.println("Hello and Welcome to the Fitness App. ");

        // Displaying exercise options to the user
        System.out.println("Please choose an exercise:");
        System.out.println("1. " + exercise1.getName());
        System.out.println("2. " + exercise2.getName());
        System.out.println("3. " + exercise3.getName());
        System.out.println("4. " + exercise4.getName());

        // Getting the user to imput their choice 
        System.out.print("Enter your choice of workout (1-4): ");
        int choice = scanner.nextInt();

        // Executing the doExercise 
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
                System.out.println("Error");
        }


        // Additional methods 
        System.out.println("Take a breath");
        exercise1.rest();
        exercise2.rest();
        exercise3.rest();
        exercise4.rest();

        System.out.println("Close your eyes and relax...");
        exercise1.coolDown();
        exercise2.coolDown();
        exercise3.coolDown();
        exercise4.coolDown();


        scanner.close();
    }
}