package testLab;

public class LabTask {
    public int addition(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public void checkInt(Long number){

    }

    public boolean checkRangeOfNumber(Long number){
        if(number < 2 || number >= 1000000000000L){
            return false;
        }
        else{
            return true;
        }
    }

    public void checkRangeOfNumberWithException(Long number){
        if(number < 2 || number >= 1000000000000L) {
            throw new IllegalArgumentException("Number is less than 2 or greater than 1000000000000");
        }
    }


    public boolean checkPrime(Long number){
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
