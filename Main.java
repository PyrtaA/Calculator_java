import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String testText = sc.nextLine();
        System.out.println(calc(testText));
    }

    public static String calc(String input) {
        String[] inputs = splitInput(input);
        int result = resultCalc(inputs);
        return String.valueOf(result);
    }

    public static String[] splitInput(String input) {
        return input.split(" ");
    }

    public static int resultCalc(String[] input) {
        return switch (input[1]) {
            case "+" -> Integer.parseInt(input[0]) + Integer.parseInt(input[2]);
            case "-" -> Integer.parseInt(input[0]) - Integer.parseInt(input[2]);
            case "/" -> Integer.parseInt(input[0]) / Integer.parseInt(input[2]);
            case "*" -> Integer.parseInt(input[0]) * Integer.parseInt(input[2]);
            default -> 0;
        };
    }
}
