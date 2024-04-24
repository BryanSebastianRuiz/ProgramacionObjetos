import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1;
        int num2;
        int result;

        System.out.print("Enter the firts binary number: ");
        num1 = scanner.nextInt(2);

        System.out.print("Enter the second binary number: ");
        num2 = scanner.nextInt(2);

        System.out.print("Select the operation: ");
        System.out.println("1) Sum");
        System.out.println("2) Subtraction");
        System.out.println("3) Multiplication");
        System.out.println("4) Division");
        
        System.out.print("Your option is: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                result = num1 / num2;
                break;
            default:
                result = 0;
                System.out.println("The option is not valid");
        }

        System.out.println("The result of the operation is: " + result);
    }
}


}
