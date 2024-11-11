//Ansh Sinha

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.Math;
import java.text.DecimalFormat;
//imports

class Calculator {
  int inputOne;
  int inputTwo;
  int option;

  int inputThree;
  int discriminant;
  // initializing variables for quadratic factoring

  int gcf;
  int smallerNumber;
  // initializing variables for division

  static int numOfCalculations = 0;
  // initializing static variable that tracks how many calculations are made

  Scanner scan = new Scanner(System.in);
  DecimalFormat df = new DecimalFormat("#.##");
  DecimalFormat noDecimal = new DecimalFormat("#");
  // initializing scanner and decimal format

  public Calculator() {
    this.inputOne = 0;
    this.inputTwo = 0;
    this.option = -1;
    this.discriminant = 0;
    this.gcf = 1;
    this.smallerNumber = 0;
  }
  // constuctor with no parameters

  public Calculator(int inputOne, int inputTwo) {
    this.inputOne = inputOne;
    this.inputTwo = inputTwo;
    this.option = -1;
    this.discriminant = 0;
    this.gcf = 1;
    this.smallerNumber = 0;
  }
  // constructor for calculator with 2 inputs

  public Calculator(int inputOne, int inputTwo, int inputThree) {
    this.inputOne = inputOne;
    this.inputTwo = inputTwo;
    this.inputThree = inputThree;
    this.option = 6;
    this.discriminant = 0;
    this.gcf = 1;
    this.smallerNumber = 0;
  }
  // constructor for quadratic formula

  public Calculator(int inputOne, int inputTwo, int inputThree, int option, int discriminant, int gcf,
      int smallerNumber) {
    this.inputOne = inputOne;
    this.inputTwo = inputTwo;
    this.inputThree = inputThree;
    this.option = option;
    this.discriminant = discriminant;
    this.gcf = gcf;
    this.smallerNumber = smallerNumber;
  }
  // constructor for every variable

  public void setInputOne() {
    System.out.println("Enter the first number: ");
    inputOne = scan.nextInt();
  }
  // method to set input one

  public int getInputOne() {
    return inputOne;
  }
  // method to get input one

  public void setInputTwo() {
    System.out.println("Enter the second number: ");
    inputTwo = scan.nextInt();
  }
  // method to set input two

  public int getInputTwo() {
    return inputTwo;
  }
  // method to get input two

  public void setInputThree() {
    System.out.println("Enter the third number: ");
    inputThree = scan.nextInt();
  }
  // method to set input three

  public int getInputThree() {
    return inputThree;
  }
  // method to get input three

  public void setOption() {
    while (option < 0 || option > 6) {
      System.out.println(
          "What type of calculation would you like to perform? (1 -> Addition, 2 -> Subtraction, 3 -> Multiplication, 4 -> Division, 5 -> Exponent");
      option = scan.nextInt();
    }
  }
  // method to set option

  public int getOption() {
    return option;
  }
  // method to get option

  public void calculatingAnimation() {
    System.out.println();
    for (int i = 0; i < 4; i++) {
      System.out.println("\u001B[A                     ");
      String animation = "\u001B[ACalculating";
      for (int x = 0; x < 4; x++) {
        System.out.println(animation);
        animation += ".";

        try {
          TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    }
  }
  // method to animate the calculating process

  public String addition() {
    return getInputOne() + " + " + getInputTwo() + " = " + (inputOne + inputTwo);
  }
  // method to return addition

  public String subtraction() {
    return getInputOne() + " - " + getInputTwo() + " = " + (inputOne - inputTwo);
  }
  // method to return subtraction

  public String multiplication() {
    return getInputOne() + " x " + getInputTwo() + " = " + (inputOne * inputTwo);
  }
  // method to return multiplication

  public void greatestCommonFactor() {
    if (inputOne < inputTwo) {
      smallerNumber = inputOne;
    } else {
      smallerNumber = inputTwo;
    }

    for (int i = 1; i <= smallerNumber; i++) {
      if (inputOne % i == 0 && inputTwo % i == 0) {
        gcf = i;
      }
    }
  }
  // method to get greatest common factor between numbers for division, to
  // simplify the fraction if necessary.

  public String division() {
    if (inputTwo == 0) {
      return "Cannot divide by 0, therefore undefined.";
    }
    if ((inputOne % inputTwo) == 0) {
      return getInputOne() + " / " + getInputTwo() + " = " + (inputOne / inputTwo);
    } else {
      greatestCommonFactor();
      return getInputOne() + " / " + getInputTwo() + " = " + ((inputOne / gcf) + " / " + (inputTwo / gcf));
      // if the numbers are not divisible, it will calculate the gcf and return the
      // simplified version.
    }
  }
  // method that returns the numbers divided by each other. If the second number
  // is equal to 0, it will return no solution.

  public String power() {
    if (inputTwo < 0) {
      return getInputOne() + " ^ " + getInputTwo() + " = " + df.format(Math.pow(inputOne, inputTwo));
      // if the exponent is negative, it will return a decimal, therefore rounding to
      // two decimals.
    } else {
      return getInputOne() + " ^ " + getInputTwo() + " = " + noDecimal.format(Math.pow(inputOne, inputTwo));
      // if the exponent is positive, it will return an integer.
    }
  }
  // method that returns the first number to the power of the second number.

  public void discriminant() {
    discriminant = (inputTwo * inputTwo) - (4 * inputOne * inputThree);
  }
  // method that calculates the discriminant for quadratic formula

  public String quadraticFactor() {
    discriminant();
    if (discriminant < 0) {
      return "The discriminant is " + discriminant + ". Therefore, there are no real roots.";
    } else if (discriminant == 0) {
      return getInputOne() + "x^2 + " + getInputTwo() + "x + " + getInputThree() + " = 0\nx = "
          + df.format((((inputTwo * -1) + Math.sqrt(discriminant)) / (2 * inputOne))) + ".";
    } else {
      return getInputOne() + "x^2 + " + getInputTwo() + "x + " + getInputThree() + " = 0\nx = "
          + df.format((((inputTwo * -1) + Math.sqrt(discriminant)) / (2 * inputOne))) + " and x = "
          + df.format((((inputTwo * -1) - Math.sqrt(discriminant)) / (2 * inputOne))) + ".";
    }
  }
  // method that returns the roots of the quadratic formula. If the discriminant
  // is negative, it wil return that there are no real roots.

  static String printNumOfCalculations() {
    return "You have made a total of " + numOfCalculations + " calculations thus far.";
  }
  // method that returns the number of calculations made.

  public void printResult() {
    if (option == 1) {
      System.out.println(addition());
    } else if (option == 2) {
      System.out.println(subtraction());
    } else if (option == 3) {
      System.out.println(multiplication());
    } else if (option == 4) {
      System.out.println(division());
    } else if (option == 5) {
      System.out.println(power());
    } else if (option == 6) {
      System.out.println(quadraticFactor());
    }
  }
  // method that determines what type of calculation to perform and prints the
  // result.

  public void calculate() {
    setOption();
    calculatingAnimation();
    printResult();
    numOfCalculations++;
    // calculation incrementation
    System.out.println(printNumOfCalculations());
  }
  // compiles all the methods together and prints the number of calculations made.
}