package Module3;

import java.math.BigInteger;
import java.util.Scanner;

public class RationalTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two rational numbers
        System.out.print("Enter the first rational number: ");
        int n1 = input.nextInt();
        int d1 = input.nextInt();
        System.out.print("Enter the second rational number: ");
        int n2 = input.nextInt();
        int d2 = input.nextInt();

        // Create Rational objects for the entered numbers
        RationalNumber r1 = new RationalNumber(n1, d1);
        RationalNumber r2 = new RationalNumber(n2, d2);

        // Perform arithmetic operations and display the results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}

class RationalNumber {
    private BigInteger numerator;
    private BigInteger denominator;

    // Construct a Rational object with default values
    public RationalNumber() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // Construct a Rational object with given numerator and denominator
    public RationalNumber(int numerator, int denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    // Construct a Rational object with given BigInteger numerator and denominator
    public RationalNumber(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    // Method to add two Rational objects
    public RationalNumber add(RationalNumber secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator).add(secondRational.numerator.multiply(denominator));
        BigInteger d = denominator.multiply(secondRational.denominator);
        return new RationalNumber(n, d);
    }

    // Method to subtract two Rational objects
    public RationalNumber subtract(RationalNumber secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator).subtract(secondRational.numerator.multiply(denominator));
        BigInteger d = denominator.multiply(secondRational.denominator);
        return new RationalNumber(n, d);
    }

    // Method to multiply two Rational objects
    public RationalNumber multiply(RationalNumber secondRational) {
        BigInteger n = numerator.multiply(secondRational.numerator);
        BigInteger d = denominator.multiply(secondRational.denominator);
        return new RationalNumber(n, d);
    }

    // Method to divide two Rational objects
    public RationalNumber divide(RationalNumber secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator);
        BigInteger d = denominator.multiply(secondRational.numerator);
        return new RationalNumber(n, d);
    }

    // Method to return the double representation of the rational number
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    // Override toString() method to represent Rational object as a string
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }
}