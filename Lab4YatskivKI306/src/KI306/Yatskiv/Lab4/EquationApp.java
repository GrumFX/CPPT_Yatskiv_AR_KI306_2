package KI306.Yatskiv.Lab4;

import java.util.Scanner;

/**
 * Дана програма є класом драйвером який тестує роботу класу Calc
 * @author Adriyan Yatskiv KI-306
 * @version 1.0
 * @since version 1.0
 */

public class EquationApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input your X in degrees: ");
        try {
            if (input.hasNextDouble()) {
                double inputAngle = input.nextDouble();
                Calc c = new Calc(inputAngle);
                System.out.println("Normalized angle: " + c.normalizeAngle() + " degrees");
                System.out.print("Tg of x = " + c.result() + "\n");
                c.in_file();
                c.close_file();
            } else {
                //throw new CustomException1("Exception: invalid data inputted");
            }
        }catch ( ArithmeticException ex) {
            System.err.println(ex.getMessage());
        } finally {
            input.close();
        }
    }
}
