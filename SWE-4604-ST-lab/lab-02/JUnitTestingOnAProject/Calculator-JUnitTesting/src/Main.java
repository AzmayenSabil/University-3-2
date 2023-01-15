import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        History history = new History();
        Validation validation = new Validation();
        UI ui = new UI();
        Conversion conversion = new Conversion();
        Trigonometry trigonometry = new Trigonometry();


        while (true) {
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number (or 0 for single-argument operations): ");
            double num2 = scanner.nextDouble();

            System.out.println("Select operation:");
            System.out.println("1. Basic Operations");
            System.out.println("2. Advance Operations");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            double result = 0;
            boolean invalid = false;
            switch (choice) {
                case 1:
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
                    AdvanceCalculator advanceCalculator = new AdvanceCalculator(num1, num2);
                    System.out.println("1. Modulo");
                    System.out.println("2. Power");
                    System.out.println("3. Square Root");
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
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            invalid = true;
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    invalid = true;
                    break;
            }
            if (!invalid) {
                System.out.println("The result is: " + result);
            }
            System.out.println();
        }
    }
}

/*
while (true) {
            ui.displayMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Basic Operations
                    System.out.print("Enter the first number: ");
                    double num1 = scanner.nextDouble();

                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();

                    System.out.print("Enter operator (+, -, *, /): ");
                    String operator = scanner.next();

                    if (!validation.isValidOperator(operator)) {
                        ui.displayError("Invalid operator. Please enter a valid operator (+, -, *, /).");
                        break;
                    }

                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                ui.displayError("Cannot divide by zero.");
                                break;
                            }
                            result = num1 / num2;
                            break;
                    }
                    System.out.println("The result is: " + result);
                    history.addCalculation(num1 + " " + operator + " " + num2 + " = " + result);
                    break;
                case 2:
                    // Advance Operations
                    System.out.print("Enter number for single-argument operations: ");
                    double number = scanner.nextDouble();

                    System.out.println("1. Feet to Meters");
                    System.out.println("2. Meters to Feet");
                    System.out.println("3. Sine");
                    System.out.println("4. Cosine");
                    System.out.println("5. Tangent");
                    System.out.print("Enter choice: ");
                    int advanceChoice = scanner.nextInt();

                    double advanceResult = 0;
                    switch (advanceChoice) {
                        case 1:
                            advanceResult = conversion.feetToMeters(number);
                            break;
                        case 2:
                            advanceResult = conversion.metersToFeet(number);
                            break;
                        case 3:
                            advanceResult = trigonometry.sine(number);
                            break;
                        case 4:
                            advanceResult = trigonometry.cosine(number);
                            break;
                        case 5:
                            advanceResult = trigonometry.tangent(number);
                            break;
                        default:
                            ui.displayError("Invalid choice. Please enter a valid option.");
                            break;
                    }
                    if (advanceChoice >= 1 && advanceChoice <= 5) {
                        System.out.println("The result is: " + advanceResult);
                        history.addCalculation(number + " = " + advanceResult);
                    }
                    break;
                case 3:
                    // History
                    history.displayHistory();
                    break;
                case 4:
                    // Exit
                    return;
                default:
                    ui.displayError("Invalid choice. Please enter a valid option.");
                    break;
            }
            System.out.println();
        }
    }
*/