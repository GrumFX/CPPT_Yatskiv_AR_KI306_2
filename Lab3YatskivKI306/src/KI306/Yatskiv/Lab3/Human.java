package KI306.Yatskiv.Lab3;

import java.io.PrintWriter;

/**
 * Клас представляє собою об'єкт людини.
 */
public abstract class Human {

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

    protected void logInfo() {
        Logger.getInstance().log("\n" + "Name: " + name);
        Logger.getInstance().log("Age: " + age);
        Logger.getInstance().log("Gender: " + gender);
        Logger.getInstance().log("Occupation: " + occupation);
    }




}
