import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String testText = sc.nextLine();
        System.out.println(calc(testText));
    }

    public static String calc(String input) throws Throwable {
        var roman = new Roman();
        int result = 0;
        String[] inputs = splitInput(input);
        if (inputs.length != 3) {
            throw new Throwable("Неверный формат записи");
        }
        if (roman.checkRomanDigit(inputs[0]) && roman.checkRomanDigit(inputs[2])) {
            int a = roman.getArabianFromRoman(inputs[0]);
            int b = roman.getArabianFromRoman(inputs[2]);
            result = resultCalc(a, b, inputs[1]);
            return roman.getRomanFromArabian(result);
        } else if (roman.checkRomanDigit(inputs[0]) && !roman.checkRomanDigit(inputs[2])) {
            throw new Throwable("Один из операндов неверного формата");
        } else if (!roman.checkRomanDigit(inputs[0]) && roman.checkRomanDigit(inputs[2])) {
            throw new Throwable("Один из операндов неверного формата");
        } else {
            try {
                result = resultCalc(inputs);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
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
    public static int resultCalc(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            case "*" -> a * b;
            default -> 0;
        };
    }
}

