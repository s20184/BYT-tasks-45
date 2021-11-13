import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.Scanner;

class TestCalculator
{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //Calling chain of responsibility
        calculator.calculate(new Operation(1,3,'+'));
        calculator.calculate(new Operation(1,3,'-'));
        calculator.calculate(new Operation(1,3,'*'));
        calculator.calculate(new Operation(1,3,'/'));

        //User input goes here:
        while(true){
            try {
                System.out.println("Enter the equation (format e.g.: '1 + 2')");
                Scanner inputScanner = new Scanner(System.in);
                String userInput = inputScanner.nextLine();
                String[] words = userInput.split(" ");
                calculator.calculate(
                        new Operation(
                                Double.parseDouble(words[0]),
                                Double.parseDouble(words[2]),
                                words[1].charAt(0)));
            }
            catch (Exception e) {
                System.out.println("There was an issue. Make sure you are using the correct operations and format.");
            }
        }
    }
}
