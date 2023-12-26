package KI306.Yatskiv.Lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Тут реалізований клас Calc який рахує tg введеного числа
 * @author Adriyan Yatskiv KI-306
 * @version 1.0
 * @since version 1.0
 */

class CustomException1 extends Exception {
    public CustomException1(String cause) {
        super(cause);
    }
}

class CalcException extends ArithmeticException {
    public CalcException() {
    }

    public CalcException(String cause) {
        super(cause);
    }
}

public class Calc {
    private double x;
    private double tg = 0;
    private PrintWriter fout;

    public Calc(double x) {
        this.x = x;
    }

    private double calculateRad() {
        return x * Math.PI / 180.0;
    }


    public double result() throws CalcException {
        try {
            double rad = calculateRad();
            tg = Math.tan(rad);

            if (Double.isNaN(tg) || Double.isInfinite(tg) || x == 90 || x == -90) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            double rad = calculateRad();

            if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0) {
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation\n");
            } else {
                throw new CalcException("Unknown reason of the exception during exception calculation");
            }
        }
        return tg;
    }

    public  double normalizeAngle() {
        // Normalize the angle to the range [0, 360] degrees
        x = x % 360;
        if (x < 0) {
            x += 360;
        }
        return x;
    }

    public void in_file() {
        try {
            fout = new PrintWriter(new BufferedWriter(new FileWriter("Lab4.txt")));
            fout.print("Tg of x = " + result() + "\n");
        } catch (IOException e) {
            System.err.println("Can't use the file!!!\n");
        }
    }


    public void close_file() {
        if (fout != null) {
            fout.close();
        }
    }
}
