/**
 * STQA PRAC-1
 * Fan ID: pent0020
 * Name: Naveen Pentela
 */
import java.util.Scanner;

public class MainFactorialDriverClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an integer: ");
            int n = scanner.nextInt();
            try {
                int result = Factorial.factorial(n);
                System.out.print("Factorial(" + n + ") = " + result);
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }

            System.out.print("Another factorial? (y/n):");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("y")) break;
        }
    }
}
