package KI306.Yatskiv.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * ���� ����������� ����� ��'��� ������.
 */
public class Human {
    private static List<String> logData = new ArrayList<>();
    private String name;
    private int age;
    private String gender;
    private String occupation;

    /**
     * ����������� � ����������� ��� ��������� ������ � ��������� ����������������.
     *
     * @param name      ��'� ������.
     * @param age       ³� ������.
     * @param gender     ����� �������.
     * @param occupation г� ��������.
     */

    public Human(String name, int age, String gender, String occupation)  {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
    }

    /**
     * ����������� �� ������������� ��� ��������� ������ � ����������� ����������.
     */

    public  Human(){
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
        this.occupation = "Unknown";
    }

    /**
     * ����� ��� ���� ���� ������.
     *
     * @param name ���� ��'� ������.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ����� ��� ���� ��� ������.
     *
     * @param age ����� �� ������.
     */
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    /**
     * ����� ��� ���� ���� ������.
     *
     * @param gender ���� ����� ������.
     */

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * ����� ��� ���� ���� ������ ������.
     *
     * @param occupation ����� �� ������ ������.
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * ����� ��� ��������� ���� ������.
     *
     * @return ��'� ������.
     */
    public String getName() {
        return name;
    }
    /**
     * ����� ��� ��������� ��� ������.
     *
     * @return ³� ������.
     */
    public int getAge() {
        return age;
    }
    /**
     * ����� ��� ��������� ���� ������.
     *
     * @return ����� ������.
     */
    public String getGender() {
        return gender;
    }
    /**
     * ����� ��� ��������� ���� ������ ������.
     *
     * @return г� ������ ������.
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * ����� ��� ����������� ���������� ��� ������.
     */
    public void printInfo() {
        System.out.println("\n" + "Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Occupation: " + occupation);
    }

    /**
     * ����� ��� �������� �� �������� � ������
     *
     * @return true ���� ������ �������, false ���� �
     */
    public boolean isAdult() {
        boolean isAdult = age > 18;
        if (isAdult) {
            System.out.println("Person is adult");
        } else {
            System.out.println("Person is underage");
        }
        return isAdult;
    }

    /**
     * ����� ��� ������ � ������ ���������� ��� ������.
     */
    public void writeToLogFile() {
        String logEntry = "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Occupation: " + occupation + "\n";

        logData.add(logEntry);
    }
    /**
     * ����� ��� ���������� ����� � ������ �� ���������� ������ � ������.
     */
    public static void saveLogToFile()  {
        try (PrintWriter writer = new PrintWriter(new FileWriter("human_log.txt", false))) {
            for (String logEntry : logData) {
                writer.println(logEntry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}