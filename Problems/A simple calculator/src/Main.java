import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        long input1 = sc.nextLong();
        String operator = sc.next();
        long input2 = sc.nextLong();

        switch (operator) {
            case "+":
                System.out.println(input1 + input2);
                break;
            case "-":
                System.out.println(input1 - input2);
                break;
            case "/":
                if(input2 == 0) {
                    System.out.println("Division by 0!");
                } else {
                    System.out.println(input1 / input2);
                }
                break;
            case "*":
                System.out.println(input1 * input2);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}