package warmup;

public class Main {

    public static void main(String[] args) {
        int amount = 0;
        int number = 0;
        while (number < 1000) {
            if (number % 3 == 0 || number % 5 == 0) {
                amount = amount + number;
            }
            number++;
                
        }
        
    }
}
