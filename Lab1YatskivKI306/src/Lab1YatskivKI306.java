/**
 * Клас Lab1YatskivKI306 реалізує приклад програми до лабораторної роботи №1
 * Варіант №11
 * @author No Information
 * @version 1.0
 * @since version 1.0
 *
 */

import java.io.*;
import java.util.*;

public class Lab1YatskivKI306
{
    /**
     * The static main method is the entry point to the program
     * @param args
     * @throws FileNotFoundException
     *
     **/

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        PrintWriter fout = new PrintWriter ("MyFile.txt");
        char[][] arr;
        int nROWS;
        String symbol;
        System.out.println("Введіть розмір квадратної матриці: ");
        nROWS = in.nextInt();
        fout.print("Розмір квадратної матриці: " + nROWS + "\n");
       /**
         * Перевірка на парність розміру матриці
         * Check for matrix size parity
         */
        if( nROWS%2 != 0 ) {
            System.out.print("Збільшення розміру матриці на 1 для отримання квадрату.\n");
            nROWS += 1;
            fout.print("Розмір збільшеної мотриці: " + nROWS + "\n");
        }

        System.out.println("Введіть символ-заповнювач: ");
        in.nextLine();
        symbol = in.nextLine();
        fout.print("Символ-заповнювач: " + symbol +"\n");
        /**
         * Перевірка введеного символа-заповнювача
         * Check the entered placeholder character
         */
        if (symbol.length() != 1)
        {
            System.out.print("\nСимвол-заповнювач введено невірно.");
            fout.print("\nСимвол-заповнювач введено невірно");
            System.exit(0);
        }
        arr = new char[nROWS][];
        /**
         * Заповнення та виведення масиву
         * Filling and outputting an array
         */
        int part_of_array = 0;
        /**
         * Ліва половина матриці
         * Left half of the matrix
         */
        for (int i = 0; i <nROWS; i++)
        {
            if(part_of_array < nROWS/2) {
                for (int middle = nROWS/2; middle > 0; middle--) {
                    System.out.print("\t");
                    fout.write("\t");
                }
                arr[i] = new char[nROWS/2];
                for (int j = 0; j < nROWS/2; j++)
                {
                    arr[i][j] = (char)symbol.codePointAt(0);
                    System.out.print(arr[i][j] + "\t");
                    fout.write(arr[i][j] + "\t");
                }
                System.out.println();
                fout.println();
            }
            /**
             * Права половина матриці
             * Right half of the matrix
             */
            else {
                arr[i] = new char[nROWS/2];
                for (int j = 0; j < nROWS/2; j++)
                {
                    arr[i][j] = (char)symbol.codePointAt(0);
                    System.out.print(arr[i][j] + "\t");
                    fout.write(arr[i][j] + "\t");
                }
                System.out.println();
                fout.println();
            }
            part_of_array +=1;
        }
        fout.close();
        in.close();
        System.out.close();
    }
}

