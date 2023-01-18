package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        History history = new History();
        UI ui = new UI();
        Conversion conversion = new Conversion();
        Trigonometry trigonometry = new Trigonometry();

        while (true) {
            ui.displayMainMenu();
            int choice = scanner.nextInt();

            double num1, num2;

            double result = 0;
            boolean invalid = false;

            switch (choice) {
                case 1:
                    System.out.print("Enter the first number: ");
                    num1 = scanner.nextDouble();

                    System.out.print("Enter the second number: ");
                    num2 = scanner.nextDouble();

                    ICalculator calculator = new Calculator(num1, num2);
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    System.out.println("4. Division");
                    System.out.print("Enter choice: ");
                    int basicChoice = scanner.nextInt();
                    switch (basicChoice) {
                        case 1:
                            result = calculator.add();
                            break;
                        case 2:
                            result = calculator.subtract();
                            break;
                        case 3:
                            result = calculator.multiply();
                            break;
                        case 4:
                            try {
                                result = calculator.divide();
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                invalid = true;
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            invalid = true;
                            break;
                    }
                    break;

                case 2:
                    System.out.print("Enter the number: ");
                    num1 = scanner.nextDouble();

                    System.out.print("Enter the second number (or 0 for single-argument operations): ");
                    num2 = scanner.nextDouble();

                    AdvanceCalculator advanceCalculator = new AdvanceCalculator(num1, num2);
                    System.out.println("1. Modulo");
                    System.out.println("2. Power");
                    System.out.println("3. Square Root");
                    System.out.println("4. Feet to Meters");
                    System.out.println("5. Meters to Feet");
                    System.out.println("6. Sine");
                    System.out.println("7. Cosine");
                    System.out.println("8. Tangent");

                    System.out.print("Enter choice: ");

                    int advanceChoice = scanner.nextInt();

                    switch (advanceChoice) {
                        case 1:
                            try {
                                result = advanceCalculator.modulo();
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                invalid = true;
                            }
                            break;
                        case 2:
                            result = advanceCalculator.power();
                            break;
                        case 3:
                            try {
                                result = advanceCalculator.squareRoot();
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                invalid = true;
                            }
                            break;
                        case 4:
                            result = conversion.feetToMeters(num1);
                            break;
                        case 5:
                            result = conversion.metersToFeet(num1);
                            break;
                        case 6:
                            result = trigonometry.sine(num1);
                            break;
                        case 7:
                            result = trigonometry.cosine(num1);
                            break;
                        case 8:
                            result = trigonometry.tangent(num1);
                            break;
                        default:
                            ui.displayError("Invalid input");
                            break;
                    }
                    if (advanceChoice >= 1 && advanceChoice <= 8) {
                        //System.out.println("The result is: " + result);
                        history.addCalculation(num1 + " = " + result);
                    }
                    break;
                case 3:
                    // Main.History
                    history.displayHistory();
                    break;
                case 4:
                    // Exit
                    return;
                default:
                    ui.displayError("Invalid input");
                    break;
            }
            if (!invalid) {
                System.out.println("The result is: " + result);
            }
            System.out.println();
        }
    }
}
