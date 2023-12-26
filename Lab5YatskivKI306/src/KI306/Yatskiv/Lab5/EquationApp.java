package KI306.Yatskiv.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Дана програма є класом драйвером який тестує роботу класу Calco
 * @author Petro Bokalo KI-306
 * @version 1.0
 * @since version 1.0
 */

public class EquationApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input your X in degrees: ");
        if (input.hasNextDouble()) {
            double inputAngle = input.nextDouble();
            Calc c = new Calc(inputAngle);
            System.out.println("Normalized angle: " + c.normalizeAngle() + " degrees");
            try {
                System.out.print("Tg of x = " + c.result() + "\n");
                c.in_fileDecimal(); // Запис у десятковому форматі
                c.in_fileBinary();  // Запис у двійковому форматі
            } catch (CalcException ex) {
                System.out.print(ex.getMessage());
            }
            c.close_files();
            input.close();

            System.out.println("Data from decimal file:");
            c.read_fileDecimal();

            System.out.println("\nData from binary file:");
            c.read_fileBinary();

            c.close_files();
        } else {
            System.out.print("Invalid data inputted \n");
        }
    }
}

