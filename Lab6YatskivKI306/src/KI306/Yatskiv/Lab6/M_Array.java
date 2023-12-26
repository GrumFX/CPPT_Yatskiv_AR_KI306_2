package KI306.Yatskiv.Lab6;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Реалізація класу M_Array
 * @author Adriyan Yatskiv KI-306
 * @version 1.0
 * @since version 1.0
 */
public class M_Array<T extends Comparable<Object>> {
    private T[] array;
    private Class<?>[] types;
    private int[] typeCounts;
    public M_Array() {
        this.array = (T[]) new Comparable[0];
        this.types = new Class<?>[0];
        this.typeCounts = new int[0];
    }


    // Пошук найбільшого значення у масиві
    public void findMaxForEachType() {
        for (int i = 0; i < types.length; i++) {
            T max = null;

            for (int j = 0; j < array.length; j++) {
                if (types[i].isInstance(array[j])) {
                    T element = (T) array[j];
                    if (max == null || element.compareTo(max) > 0) {
                        max = element;
                    }
                }
            }
            System.out.println("Максимальне значення для типу " + types[i].getName() + ": " + max);
        }
    }

    public void insert(T element) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = element;

        Class<?> elementType = element.getClass();
        int index = getTypeIndex(elementType);

        if (index == -1) {
            types = Arrays.copyOf(types, types.length + 1);
            types[types.length - 1] = elementType;

            typeCounts = Arrays.copyOf(typeCounts, typeCounts.length + 1);
            typeCounts[typeCounts.length - 1] = 1;
        } else {
            typeCounts[index]++;
        }
    }
    // Видалення елементу з масиву за значенням
    public T remove(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                T removedElement = array[i];
                T[] newArray = Arrays.copyOf(array, array.length - 1);
                System.arraycopy(array, 0, newArray, 0, i);
                System.arraycopy(array, i + 1, newArray, i, array.length - i - 1);
                array = newArray;
                return removedElement;
            }
        }
        return null;
    }
    private int getTypeIndex(Class<?> elementType) {
        for (int i = 0; i < types.length; i++) {
            if (types[i] == elementType) {
                return i;
            }
        }
        return -1;
    }

    public int countStringsT() {
        int count = 0;

        for (T element : array) {
                String str = element.toString();
                if (str.startsWith("T")) {
                    count++;
            }
        }

        System.out.println("Number of strings starting with 'T': " + count);
        return count;
    }


    public void display() {
        System.out.println(Arrays.toString(array));
    }

    public void printTypeCounts() {
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i].getName() + ": " + typeCounts[i]);
        }
    }
}