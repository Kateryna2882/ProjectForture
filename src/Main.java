import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Shape Area Calculator");

        int invalidAttempts = 0; // Лічильник спроб введення невірного значення

        while (true) {
            System.out.println();
            System.out.println("-=-=-=-=-=-=-=-=-=-");
            System.out.println();
            System.out.println("1) Triangle");
            System.out.println("2) Rectangle");
            System.out.println("3) Circle");
            System.out.println("4) Quit");
            System.out.println();

            System.out.print("Which shape: ");
            int shape = getIntInput(keyboard);

            if (shape == 1) {
                System.out.print("Base: ");
                int base = getPositiveIntInput(keyboard);
                System.out.print("Height: ");
                int height = getPositiveIntInput(keyboard);
                area_triangle(base, height);
                invalidAttempts = 0; // Скидаємо лічильник, якщо ввід коректний

            } else if (shape == 2) {
                System.out.print("Length: ");
                int length = getPositiveIntInput(keyboard);
                System.out.print("Width: ");
                int width = getPositiveIntInput(keyboard);
                area_rectangle(length, width);
                invalidAttempts = 0;

            } else if (shape == 3) {
                System.out.print("Radius: ");
                int radius = getPositiveIntInput(keyboard);
                area_circle(radius);
                invalidAttempts = 0;

            } else if (shape == 4) {
                quit();
                break;

            } else {
                System.out.println("Invalid option. Please select a number from 1 to 4.");
                invalidAttempts++; // Збільшуємо лічильник при некоректному введенні
                if (invalidAttempts >= 3) {
                    System.out.println("Too many invalid attempts. Exiting program.");
                    break;
                }
            }
        }
    }

    public static double area_triangle(int base, int height) {
        System.out.println();
        double A = (base * height) / 2.0;
        System.out.println("The area is " + A + ".");
        return A;
    }

    public static double area_rectangle(int length, int width) {
        System.out.println();
        double A = length * width;
        System.out.println("The area is " + A + ".");
        return A;
    }

    public static double area_circle(int radius) {
        System.out.println();
        double A = Math.PI * radius * radius;
        System.out.println("The area is " + A + ".");
        return A;
    }

    public static void quit() {
        System.out.println("Good Bye");
    }

    public static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next();
            }
        }
    }

    public static int getPositiveIntInput(Scanner scanner) {
        int value;
        do {
            value = getIntInput(scanner);
            if (value <= 0) {
                System.out.print("Please enter a positive integer: ");
            }
        } while (value <= 0);
        return value;
    }
}
