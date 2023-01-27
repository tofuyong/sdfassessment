import java.io.Console;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome.");

        boolean exit = false;
        double $last = 0;
        double number1;
        double number2;
        String operator;

        while (!exit) {
            Console cons = System.console();
            String cli = cons.readLine(">");

            if (cli.contains("exit")) {
                System.out.println("Bye bye");
                exit = true;
                break;
            } 

            String[] inputArray = cli.split(" ");
            
            if (inputArray[0].equals("$last")){
                number1 = $last;
            } else {
                number1 = Double.parseDouble(inputArray[0]);
            }
            
            if (inputArray[2].equals("$last")){
                number2 = $last;
            } else {
                number2 = Double.parseDouble(inputArray[2]);
            }

            operator = inputArray[1];
            switch (operator) {
                case "+":
                    $last = addition(number1, number2);
                    break;
                case "-":
                    $last = minus(number1, number2);
                    break;
                case "*":
                    $last = multiply(number1, number2);
                    break;
                case "/":
                    $last = divide(number1, number2);
                    break;
                default:
                    System.out.println("Invalid input");
            }

            String answer = String.valueOf($last);
            System.out.println(answer.replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", ""));

        }
    }

    public static double addition(double number1, double number2) {
        return number1 + number2;
    }

    public static double minus(double number1, double number2) {
        return number1 - number2;
    }

    public static double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public static double divide(double number1, double number2) {
        return number1 / number2;
    }
}