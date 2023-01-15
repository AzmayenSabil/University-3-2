class AdvanceCalculator extends Calculator {

    public AdvanceCalculator(double num1, double num2) {
        super(num1, num2);
    }

    public double modulo() {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return num1 % num2;
    }

    public double power() {
        return Math.pow(num1, num2);
    }

    public double squareRoot() {
        if (num1 < 0) {
            throw new IllegalArgumentException("Cannot take square root of negative number.");
        }
        return Math.sqrt(num1);
    }
}