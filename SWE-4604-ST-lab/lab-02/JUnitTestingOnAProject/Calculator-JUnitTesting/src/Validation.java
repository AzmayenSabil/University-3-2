public class Validation {
    public boolean isValidOperator(String operator) {
        return "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
    }

    public boolean isValidNumber(double num) {
        return num > 0;
    }
}
