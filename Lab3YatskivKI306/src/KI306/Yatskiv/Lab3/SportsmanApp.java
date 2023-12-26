package KI306.Yatskiv.Lab3;

public class SportsmanApp {
    public static void main(String[] args)  {
        // ��������� ���������� � ������ ��'��, ����, ������ �� ����� ������
        Sportsman sportsman1 = new Sportsman("John", 37, "Male", "Athlete", "Swimming",7,8,4, 20);
        sportsman1.logInfo();
        sportsman1.training(6); // ���������� ���������� �� 6 �����
        sportsman1.compete(); // ���������� ��������

        // ��������� ������ ����������
        Sportsman sportsman2 = new Sportsman("Mary", 32, "Female", "Athlete", "Running",3,4,6, 13);
        sportsman2.logInfo();
        sportsman2.training(4); // ���������� ���������� �� 4 �����
        sportsman2.compete(); // ���������� ��������
        Sportsman sportsman3 = new Sportsman("Taras", 32, "Male", "Athlete", "Running",3,4,6, 13);
        Sportsman sportsman4 = new Sportsman("Ivan", 32, "Male", "Athlete", "Running",3,4,6, 13);
        Sportsman sportsman5 = new Sportsman("Marie", 32, "Female", "Athlete", "Running",3,4,6, 13);
        Sportsman sportsman6 = new Sportsman("David", 32, "Male", "Athlete", "Running",3,4,6, 13);
        Sportsman sportsman7 = new Sportsman("Osen", 32, "Female", "Athlete", "Running",3,4,6, 13);


        System.out.println("Male sportsmen number: " + Sportsman.getMaleCount());
        System.out.println("Female sportsmen number: " + Sportsman.getFemaleCount());
    }
}
