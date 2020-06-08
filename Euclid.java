/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author esheinon
 */
/**
 * This is a small program demonstrating the Euclidean algorithm to find
 * the greatest common divisor, gcd(a,b), of two integers a and b. It also gives
 * the least common multiple, lcm(a,b), via the formula gcd(a,b)*lcm(ab) = a*b.
 * 
 * It is assumed that the user will insert only numbers.
 *
 */
import java.util.Scanner;

public class Euclid {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
	
        // Determine integers that will be used to perform the Euclidean algorithm.
        int a;
        int b;

        while (true) {

            System.out.println("Give two integers a and b for which you want to find the greatest common divisor and least common multiple.");
            System.out.println("The result is given for positive numbers since gcd(a,b) = gcd(-a,b) = gcd(a,-b) = gcd(-a,-b).");
            System.out.println("Empty insert for the first number will end the program.");
            System.out.println("");
            System.out.print("First number: ");
            String cmd = scan.nextLine();
            if (cmd.equals("")) {
                break;
            }
            int n1 = Integer.valueOf(cmd);
            System.out.print("Second number: ");
            int n2 = Integer.valueOf(scan.nextLine());

            // This is to make sure that the integers are positive and put them into right order.
	
            if (n1 < 0) {
                n1 = -1 * n1;
            }
            if (n2 < 0) {
                n2 = -1 * n2;
            }
            if (n1 <= n2) {
                a = n1;
                b = n2;
            } else {
                a = n2;
                b = n1;
            }

            // Compute the product to be able to get lcm(a,b) at the end.
            int prod = n1 * n2;

            // The algorithm is inside the following while loop.
            // We use the following fact: if a = kb + r, 0<= r < b, for some integer k, then gcd(a,b) = gcd(b,r).
            // This can be repeated until r = 0 (substituting a = b and b = r) and the we get gcd(a,b) as the final value of b.     

            while (true) {
                if (a == 0 && b == 0) {
                    System.out.println("Cannot compute gcd(a,b) or lcm(a,b) if a=0 and b=0. \n");
                    break;
                }
                if (a == 0) {
                    System.out.println("gcd(" + n1 + "," + n2 + ") = " + b + " and lcm(" + a + "," + b + ") = 0. \n");
                    break;
                }
                if (b == 0) {
                    System.out.println("gcd(" + n1 + "," + n2 + ") = " + a + " and lcm(" + a + "," + b + ") = 0. \n");
                    break;
                }

                // Determine r as the reminder when a is divided by b.
                int r = a % b;

                if (r == 0) {
                    System.out.println("gcd(" + n1 + "," + n2 + ") = " + b
                            + " and lcm(" + n1 + "," + n2 + ") = " + prod / b + ". \n");
                    break;
                } else {
                    a = b;
                    b = r;
                }
            }
        }
    }
}