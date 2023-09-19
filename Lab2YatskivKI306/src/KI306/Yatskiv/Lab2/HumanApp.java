package KI306.Yatskiv.Lab2;

import java.io.*;

public class HumanApp {
    public static void main(String[] args) throws FileNotFoundException {
        //Створення об'єкту людини
        Human person1 = new Human("Oleg", 30, "Male","Software Developer");
        Human person2 = new Human("Alice", 25, "Female","Unemployed");
        Human person3 = new Human("David", 58, "Male","Politician");
        Human person4 = new Human("Meg", 17, "Female","Student");
        //Вивід інформації
        person1.printInfo();
        person2.printInfo();
        //Перевірка чи людина доросла
        person2.isAdult();
        //Зміна віку
        person3.setAge(45);
        //Вивід інформаціх
        person3.printInfo();

        //Зміна імені
        person4.setName("Petro");
        //Зміна статі
        person4.setGender("Male");
        //Вивід інформації
        person4.printInfo();
        //Перевірка чи доросла людина
        person4.isAdult();

        //Запис у файл
        person1.writeToLogFile();
        person2.writeToLogFile();
        person3.writeToLogFile();
        person4.writeToLogFile();
        //Збереження записаних даних
        Human.saveLogToFile();
    }
}
