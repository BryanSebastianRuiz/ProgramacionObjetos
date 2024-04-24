import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Calculator3 {
    
    // Sum binary numbers
    public static String sumBinary(String binary1, String binary2) {
        BigInteger num1 = new BigInteger(binary1, 2);
        BigInteger num2 = new BigInteger(binary2, 2);
        BigInteger sum = num1.add(num2);
        return sum.toString(2); // Returns the sum in binary
    }
    
    // Subtract binary numbers
    public static String subtractBinary(String binary1, String binary2) {
        BigInteger num1 = new BigInteger(binary1, 2);
        BigInteger num2 = new BigInteger(binary2, 2);
        BigInteger diff = num1.subtract(num2);
        return diff.toString(2); // Returns the difference in binary
    }
    
    // Convert a decimal number to binary
    public static String decimalToBinary(String decimal) {
        BigDecimal num = new BigDecimal(decimal);
        BigInteger intPart = num.toBigInteger();
        BigDecimal fractionalPart = num.remainder(BigDecimal.ONE);
        StringBuilder binaryBuilder = new StringBuilder(intPart.toString(2));
        
        if (fractionalPart.compareTo(BigDecimal.ZERO) != 0) {
            binaryBuilder.append('.');
            for (int i = 0; i < 10; i++) {
                fractionalPart = fractionalPart.multiply(BigDecimal.valueOf(2));
                binaryBuilder.append(fractionalPart.intValue());
                fractionalPart = fractionalPart.remainder(BigDecimal.ONE);
                if (fractionalPart.compareTo(BigDecimal.ZERO) == 0) {
                    break;
                }
            }
        }
        
        return binaryBuilder.toString(); // Returns the binary representation
    }
    
    // Obtain the hexadecimal representation of a decimal number
    public static String decimalToHexadecimal(String decimal) {
        BigDecimal num = new BigDecimal(decimal);
        BigInteger intPart = num.toBigInteger();
        return intPart.toString(16); // Returns the integer part in hexadecimal
    }
    
    // Obtain the octal representation of a decimal number
    public static String decimalToOctal(String decimal) {
        BigDecimal num = new BigDecimal(decimal);
        BigInteger intPart = num.toBigInteger();
        return intPart.toString(8); // Returns the integer part in octal
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first binary number:");
        String binary1 = scanner.nextLine();

        System.out.println("Enter the second binary number:");
        String binary2 = scanner.nextLine();

        System.out.println("Enter a decimal number:");
        String decimal = scanner.nextLine();

        scanner.close();

        System.out.println("Binary sum: " + sumBinary(binary1, binary2));
        System.out.println("Binary subtraction: " + subtractBinary(binary1, binary2));
        System.out.println("Decimal to binary: " + decimalToBinary(decimal));
        System.out.println("Decimal to hexadecimal: " + decimalToHexadecimal(decimal));
        System.out.println("Decimal to octal: " + decimalToOctal(decimal));
    }
}
