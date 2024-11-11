//Goshanraj Govindaraj

//import scanner
import java.util.Scanner;

public class FoodTracker {
  
// variables for user data
// includes multiple properties
  private String name;
  private String gender;
  private int age;
  private int weight;
  private int height;
  private int activitylevel;
  private double totalIntake;
  
// static variable
  public static double waterIntake;
  Scanner scan = new Scanner(System.in);

// constructor
  public FoodTracker() {
    this.name = "";
    this.gender = "";
    this.age = 0;
    this.weight = 0;
    this.height = 0;
    this.activitylevel = 0;
    this.totalIntake = 0;
  }
  
//initializing static variable
  public FoodTracker(double initialWaterIntake) {
    this();
    FoodTracker.waterIntake = 0;
  }

// static method
  public static double calculateWaterIntake(int weight) {
    return weight * 35;
  }

// getter method for name
  public String getName() {
    return name;
  }

// setter method
  public void setName(String name) {
    this.name = name;
  }

// method to input name
  public void inputName() {
    System.out.println("What is your name?");
    String inputName = scan.nextLine();
    setName(inputName);
  }

// getter method for gender
  public String getGender() {
    return gender;
  }

// setter method
  public void setGender(String gender) {
    this.gender = gender;
  }

// method to input gender
  public void inputGender() {
    System.out.println("What is your gender? (M/F)");
    String inputGender = scan.nextLine();
    setGender(inputGender);
  }

// getter method for age
  public int getAge() {
    return age;
  }

// setter method for age
  public void setAge(int age) {
    this.age = age;
  }

// method to input age
  public void inputAge() {
    System.out.println("What is your age in years? [ENTER A WHOLE NUMBER]");
    int inputAge = scan.nextInt();
    setAge(inputAge);
  }

// getter method for weight
  public int getWeight() {
    return weight;
  }

// setter method for weight
  public void setWeight(int weight) {
    this.weight = weight;
    updateWaterIntake(weight);
  }

// static method for updating water intake
  public static void updateWaterIntake(int weight) {
    waterIntake = weight * 35;
  }

// method to input weight
  public void inputWeight() {
    System.out.println("What is your weight in kg? [ROUND TO NEAREST WHOLE NUMBER]");
    int inputWeight = scan.nextInt();
    setWeight(inputWeight);
  }

// getter method for height
  public int getHeight() {
    return height;
  }

// setter method for height
  public void setHeight(int height) {
    this.height = height;
  }

// method to input height
  public void inputHeight() {
    System.out.println("What is your height in cm? [ROUND TO NEAREST WHOLE NUMBER]");
    int inputHeight = scan.nextInt();
    setHeight(inputHeight);
  }

// getter method for activity level
  public int getActivityLevel() {
    return activitylevel;
  }

// setter method for activity level
  public void setActivityLevel(int activitylevel) {
    this.activitylevel = activitylevel;
  }

// method to input activity level
  public void inputActivityLevel() {
    System.out.println("What is your activity level? [1-4]");
    System.out.println("1 -> Sedentary, or little to no exercise");
    System.out.println("2 -> Lightly active, or exercise 1-3 times per week");
    System.out.println("3 -> Moderately active, or exercise 4-5 times per week");
    System.out.println("4 -> Very active, or exercise 6-7 times per week");
    int inputActivityLevel = scan.nextInt();
    setActivityLevel(inputActivityLevel);
  }

// method to calculate required BMR, and caloric requirements
  public double calculateBMR() {
    double levelmultiplier = 0;
    if (activitylevel == 1) {
      levelmultiplier = 1.2;
    } else if (activitylevel == 2) {
      levelmultiplier = 1.375;
    } else if (activitylevel == 3) {
      levelmultiplier = 1.55;
    } else if (activitylevel == 4) {
      levelmultiplier = 1.725;
    }
    
//calculations for BMR + multiplied by activity level to show recomended caloric intake
    if (gender.equalsIgnoreCase("M")) {
      return (66 + (13.7 * weight) + (5 * height) - (6.8 * age)) * levelmultiplier;
    } else if (gender.equalsIgnoreCase("F")) {
      return (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) * levelmultiplier;
    }
    return 0;
  }

// calculating total caloric intake of a day
//asks user for caloric content for their meals
  public void logFoodIntake() {
    totalIntake = 0;
    System.out.println("How many meals will you be logging today?");
    int meals = scan.nextInt();
    for (int i = 0; i < meals; i++) {
      System.out.println("Enter the calorie content for meal " + (i + 1) + ":");
      totalIntake += scan.nextInt();
    }
    scan.nextLine();
  }

// analyzes the statistics, and gives an overview
  public void analyzeIntake() {
    double BMR = calculateBMR();
    BMR = Math.round(BMR);
    System.out.println("----------------");
    System.out.println("Daily caloric requirement to maintain weight is " + BMR + " calories per day.");
    System.out.println("Total caloric intake for the day is " + totalIntake + " calories");
    if (totalIntake > BMR) {
      System.out.println(
          "You have consumed more than your daily requirement, you are in a calorie surplus and you will gain weight");
    } else if (totalIntake < BMR) {
      System.out.println(
          "You have consumed less than your daily requirement, you are in a calorie deficit and you will lose weight");
    } else {
      System.out.println("You have met your daily goal, you are in a calorie maintence, you will maintain your weight");
    }
  }
  
//calling all methods
  public void track() {
    inputName();
    inputGender();
    inputAge();
    inputWeight();
    inputHeight();
    inputActivityLevel();
    logFoodIntake();
    analyzeIntake();
    System.out.println("Recommended Water Intake: " + waterIntake + " ml");
  }
}