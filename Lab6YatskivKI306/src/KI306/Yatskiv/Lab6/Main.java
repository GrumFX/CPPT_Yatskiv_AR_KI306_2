package KI306.Yatskiv.Lab6;

import java.util.Map;

/**
 * Дана програма є класом драйвером який тестує роботу класу M_Array
 * @author Adriyan Yatskiv KI-306
 * @version 1.0
 * @since version 1.0
 */

public class Main {
    public static void main(String[] args) {
        M_Array container = new M_Array<>();
        // Додавання елементів
        container.insert(42);
        container.insert(8);
        container.insert(3.94);
        container.insert(9);
        container.insert("Sample");
        container.insert(-2);
        container.insert(5.5);
        container.insert(2);
        container.insert("Text");
        container.insert("-19.5");
        container.insert("Something");
        container.insert("Tnfo");
        container.insert("Trembita");
        container.insert("Trembita");

        container.remove(5);

        System.out.println("Масив: ");
        container.display();

       container.findMaxForEachType();

        System.out.println("Кількість елементів кожного типу:");
        container.printTypeCounts();

        container.countStringsT();

        }

    }
