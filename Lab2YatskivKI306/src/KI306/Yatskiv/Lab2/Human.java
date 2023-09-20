package KI306.Yatskiv.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * Клас представляє собою об'єкт людини.
 */
public class Human {
    private static List<String> logData = new ArrayList<>();
    private String name;
    private int age;
    private String gender;
    private String occupation;

    /**
     * Конструктор з параметрами для створення людини з вказаними характеристиками.
     *
     * @param name      Ім'я людинм.
     * @param age       Вік людини.
     * @param gender     Стать лююдини.
     * @param occupation Рід занятості.
     */

    public Human(String name, int age, String gender, String occupation)  {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
    }

    /**
     * Конструктор за замовчуванням для створення людини з ініціальними значеннями.
     */

    public  Human(){
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
        this.occupation = "Unknown";
    }

    /**
     * Метод для зміни імені людини.
     *
     * @param name Нове ім'я людини.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для зміни віку людини.
     *
     * @param age Новий вік людини.
     */
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    /**
     * Метод для зміни статі людини.
     *
     * @param gender нова стать людини.
     */

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Метод для зміни роду занять людини.
     *
     * @param occupation новий рід занять людини.
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * Метод для отримання імені людини.
     *
     * @return Ім'я людини.
     */
    public String getName() {
        return name;
    }
    /**
     * Метод для отримання віку людини.
     *
     * @return Вік людини.
     */
    public int getAge() {
        return age;
    }
    /**
     * Метод для отримання статі людини.
     *
     * @return Стать людини.
     */
    public String getGender() {
        return gender;
    }
    /**
     * Метод для отримання роду занять людини.
     *
     * @return Рід занять людини.
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Метод для відображення інформації про людину.
     */
    public void printInfo() {
        System.out.println("\n" + "Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Occupation: " + occupation);
    }

    /**
     * Метод для перевірки чи дорослою є людина
     *
     * @return true якщо людина доросла, false якщо ні
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
     * Метод для запису в журнал інформаціх про людину.
     */
    public void writeToLogFile() {
        String logEntry = "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Occupation: " + occupation + "\n";

        logData.add(logEntry);
    }
    /**
     * Метод для збереження даних у журналі та завершення роботи з файлом.
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
