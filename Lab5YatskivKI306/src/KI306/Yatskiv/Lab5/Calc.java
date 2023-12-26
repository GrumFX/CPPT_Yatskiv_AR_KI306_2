package KI306.Yatskiv.Lab5;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * Тут реалізований клас Calc який рахує tg введеного числа
 * @author Adriyan Yatskiv KI-306
 * @version 1.0
 * @since version 1.0
 */
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
    private PrintWriter foutDecimal;
    private FileOutputStream foutBinary;
    private FileInputStream finDecimal;
    private FileInputStream finBinary;
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

    public void in_fileDecimal() {
        try {
            foutDecimal = new PrintWriter(new BufferedWriter(new FileWriter("Lab5Decimal.txt")));
            foutDecimal.printf("Tg of x in decimal format = %.10f%n", result());
        } catch (IOException e) {
            System.err.println("Can't use the file!!!\n");
        }
    }

    public void in_fileBinary() {
        try {
            String fileName = "Lab5Binary.bin";
            foutBinary = new FileOutputStream(fileName);
            foutBinary.write(DoubleToBinary(result()));
        } catch (IOException e) {
            System.err.println("Can't use the file!!!\n");
        }
    }

    public void read_fileDecimal() {
        try {
            finDecimal = new FileInputStream("Lab5Decimal.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(finDecimal));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            finDecimal.close();
        } catch (IOException e) {
            System.err.println("Can't read the file!!!\n");
        }
    }

    public void read_fileBinary() {
        try {
            finBinary = new FileInputStream("Lab5Binary.bin");
            byte[] buffer = new byte[8];
            int bytesRead;
            while ((bytesRead = finBinary.read(buffer)) != -1) {
                long bits = ByteBuffer.wrap(buffer).getLong();
                double result = Double.longBitsToDouble(bits);
                System.out.printf("Tg of x in binary format = %.10f%n", result);
            }
        } catch (IOException e) {
            System.err.println("Can't read the file!!!\n");
        }
    }

    public void close_files() {
        if (foutDecimal != null) {
            foutDecimal.close();
        }
        if (foutBinary != null) {
            try {
                foutBinary.close();
            } catch (IOException e) {
                System.err.println("Error while closing binary file");
            }
        }
        if (finDecimal != null) {
            try {
                finDecimal.close();
            } catch (IOException e) {
                System.err.println("Error while closing decimal file");
            }
        }
        if (finBinary != null) {
            try {
                finBinary.close();
            } catch (IOException e) {
                System.err.println("Error while closing binary file");
            }
        }
    }

    // Метод для перетворення результату в двійковий формат
    private byte[] DoubleToBinary(double number) {
        long bits = Double.doubleToLongBits(number);
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(bits);
        return buffer.array();
    }
}
