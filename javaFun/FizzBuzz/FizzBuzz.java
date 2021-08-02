public class FizzBuzz {
    public String fizzBuzz(int number, String multOf3Word, String multOf5Word, String multOf15Word) {
        // Check divisibility by 3 and 5
        if ((number%3) == 0 && (number%5) == 0) {
            return String.format("%s", multOf15Word);
        }
        else if ((number%3) == 0) {
            return String.format("%s", multOf3Word);
        }
        else if ((number%5) == 0) {
            return String.format("%s", multOf5Word);
        }
        else {
            return String.valueOf(number);
        }
    }
}