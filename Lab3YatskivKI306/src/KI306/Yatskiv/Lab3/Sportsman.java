package KI306.Yatskiv.Lab3;

import java.util.Random;

interface Athlete {
    void compete();
}

/**
 * Реалізація класу Sportsman
 * @author Adriyan Yatskiv KI-306
 * @version 1.0
 * @since version 1.0
 */
public class Sportsman extends Human implements Athlete {
    private String sport;
    private int experience;
    private double skillLevel;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;

    private static int femaleCount = 0;
    private static int maleCount = 0;

    /**
    Конструктор класу Sportsman
    */
    public Sportsman(String name, int age, String gender, String occupation, String sport, int goldMedals, int silverMedals, int bronzeMedals, int experience)  {
        super(name, age, gender, occupation);
        this.sport = sport;
        this.experience = experience;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
        this.skillLevel = calculateSkillLevel(experience);

        if (gender.equalsIgnoreCase("Female")) {
            femaleCount++;}
        if (gender.equalsIgnoreCase("Male")) {
            maleCount++;}
    }

    /**
     *  Конструтор по замовчуванню класу Sportsman
     */

    public Sportsman()  {
        this.sport = "Unknown";
        this.experience = 0;
        this.skillLevel = calculateSkillLevel(0);
    }
    public static int getFemaleCount() {

        return femaleCount;
    }

    public static int getMaleCount() {

        return maleCount;
    }

    /**
     * Отримання поточного спорту
     */
    public String getSport() {
        return sport;
    }

    /**
     * Призначення  спорту
     */
    public void setSport(String sport) {this.sport = sport; }

    /**
     * Отримання  досвіду спортсмена у числовому значенні
     */
    public int getExperience() {
        return experience;
    }

    /**
     *  Призначення  досвіду спортсмена у числовому значенні
     */
    public void setExperience(int experience) {
        this.experience = experience;
        this.skillLevel = calculateSkillLevel(experience);
    }

    /**
     * Отримання  рівня навичок спортсмена у числовому значенні
     */
    public double getSkillLevel() {
        return skillLevel;
    }

    /**
     * Отримання кількості золотих медалей спортсмена
     */
    public int getGoldMedals() {
        return goldMedals;
    }

    /**
     * Отримання кількості срібних медалей спортсмена
     * @return
     */
    public int getSilverMedals() {
        return silverMedals;
    }

    /**
     * Отримання кількості бронзових медалей спортсмена
     * @return
     */
    public int getBronzeMedals() {
        return bronzeMedals;
    }

    /**
     * Обрахунок рвня навичок спортсмена
     * @param experience
     * @return
     */
    private double calculateSkillLevel(int experience) {
        return 0.5 + (experience / 5.0); // базовий рівень + 0.1 за кожні 5 років досвіду
    }

    /**
     * Логування діяльності спортсмена та вивід інформації на екран
     */
    @Override
    public void logInfo() {
        super.logInfo();
        Logger.getInstance().log("Sport: " + sport);
        Logger.getInstance().log("Gold Medals: " + goldMedals);
        Logger.getInstance().log("Silver Medals: " + silverMedals);
        Logger.getInstance().log("Bronze Medals: " + bronzeMedals);
        Logger.getInstance().log("Experience: " + experience + " years");
        Logger.getInstance().log("Skill Level: " + skillLevel);
    }

    /**
     * Симуляція змагань
     */
    public void compete() {
        Logger.getInstance().log(getName() + " is competing in " + sport);

        // Розрахунок шансів на виграш медалі залежно від рівня вмінь
        double skillFactor = skillLevel * 10; // Перетворення рівня вмінь у відсотки (0-100%)
        Random random = new Random();
        double randomValue = random.nextDouble() * 100; // Випадкове число від 0 до 100

        // Шанси на виграш різних медалей
        double goldChance = skillFactor;
        double silverChance = Math.min(skillFactor * 0.7, 100); // Не більше 100%
        double bronzeChance = Math.min(skillFactor * 0.5, 100); // Не більше 100%

        if (randomValue <= goldChance) {
            goldMedals++;
            Logger.getInstance().log("Congratulations! " + getName() + " has won a GOLD medal!\nGold medals: "+ getGoldMedals());
        } else if (randomValue <= (goldChance + silverChance)) {
            Logger.getInstance().log("Congratulations! " + getName() + " has won a SILVER medal!\nSilver medals: " + getSilverMedals());
            silverMedals++;
        } else if (randomValue <= (goldChance + silverChance + bronzeChance)) {
            Logger.getInstance().log("Congratulations! " + getName() + " has won a BRONZE medal!\nBronze medals: " + getBronzeMedals());
            bronzeMedals++;
        } else {
            Logger.getInstance().log("Unfortunately, " + getName() + " did not win a medal.");
        }
    }

    /**
     * Симуляція тренувань
     * @param hours
     */
    public void training(int hours) {
        Logger.getInstance().log(getName() + " is training for " + hours + " hours.");
        experience += hours / 365; // Припускаємо, що спортсмен тренується 1 годину на день.
        skillLevel = calculateSkillLevel(experience);
    }
}
