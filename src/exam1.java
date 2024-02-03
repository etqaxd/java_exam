import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class exam1 {

    private static final int MAX_DAYS = 30;
    private static double[] expenses = new double[MAX_DAYS];
    public static int choice;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Основное меню:");
            System.out.println("1 – Ввести расходы за определенный день");
            System.out.println("2 – Вывести расходы за месяц");
            System.out.println("3 – Конвертер валюты");
            System.out.println("4 – Вывести самый затратный день");
            System.out.println("0 – Выход");

            System.out.print("Выберите пункт меню: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterExpenses(scanner);
                    break;
                case 2:
                    printExpenses();
                    break;
                case 3:
                    valueConvert();
                    break;
                case 4:
                    printMostExpensiveDay();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);

                    break;
                default:
                    System.out.println("Некорректный выбор. Повторите попытку.");
            }
        } while (choice != 0);
    }


    private static void enterExpenses(Scanner scanner) {
        System.out.print("Введите день (от 1 до 30): ");
        int day = scanner.nextInt();

        if (day <= 0 || day > MAX_DAYS) {
            System.out.println("Некорректный день. Повторите попытку.");
            return;
        }

        if (expenses[day - 1] != 0) {
            System.out.print("За данный день уже указана сумма трат. Перезаписать? (да/нет): ");
            String overwriteChoice = scanner.next();

            if (overwriteChoice.equalsIgnoreCase("нет")) {
                return;
            }
        }

        System.out.print("Введите сумму трат за текущий день: ");
        double amount = scanner.nextDouble();

        expenses[day - 1] = amount;

        System.out.print("Хотите ввести трату за другой день? (да/нет): ");
        String continueChoice = scanner.next();

        if (continueChoice.equalsIgnoreCase("да")) {
            enterExpenses(scanner);
        }
    }


    private static void printExpenses() {
        System.out.println("Траты за месяц:");

        for (int i = 0; i < 30; i++) {
            if (expenses[i] != 0) {
                System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                System.out.println("День " + (i + 1) + ": " + expenses[i]);
                System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            }
        }
    }

    public static void valueConvert() {
        Scanner scanner = new Scanner(System.in);
        int choiceConvert;
        do {
            System.out.println("Меню конвертации:");
            System.out.println("1 - Конвертировать в Евро");
            System.out.println("2 - Конвертировать в Доллары");
            System.out.println("3 - Конвертировать в Юани");
            System.out.println("4 - Выйти в оснвное меню");

            System.out.println("Выберите пункт меню:");

            choiceConvert = scanner.nextInt();
            scanner.nextLine();
            switch (choiceConvert) {
                case 1:
                    System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                    euroConvert();
                    System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                    break;
                case 2:
                    System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                    dollarConvert();
                    System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                    break;
                case 3:
                    System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                    yuansConvert();
                    System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                    break;
                case 4:
                    mainTwo();
                    break;
            }

        } while (choiceConvert != 0);
    }

    public static void euroConvert() {
        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] != 0) {
                double euroAmount = expenses[i] / 97;
                System.out.println("День " + (i + 1) + ": " + euroAmount + " Euro");
            }
        }
    }

    public static void dollarConvert() {
        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] != 0) {
                double dollarAmount = expenses[i] / 87;
                System.out.println("День " + (i + 1) + ": " + dollarAmount + " $");
            }
        }
    }

    public static void yuansConvert() {
        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] != 0) {
                double yuansAmount = expenses[i] / 12;
                System.out.println("День " + (i + 1) + ": " + yuansAmount + " Yuans");
            }
        }
    }

    public static void mainTwo() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Основное меню:");
            System.out.println("1 – Ввести расходы за определенный день");
            System.out.println("2 – Вывести расходы за месяц");
            System.out.println("3 – Конвертер валюты");
            System.out.println("4 – Вывести самый затратный день");
            System.out.println("0 – Выход");

            System.out.print("Выберите пункт меню: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterExpenses(scanner);
                    break;
                case 2:
                    printExpenses();
                    break;
                case 3:
                    valueConvert();
                    break;
                case 4:
                    printMostExpensiveDay();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Повторите попытку.");
            }
        } while (choice != 0);
    }

    private static void printMostExpensiveDay() {
        double maxExpense = 0;
        int maxDay = 0;

        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] > maxExpense) {
                maxExpense = expenses[i];
                maxDay = i + 1;
            }
        }
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        System.out.println("Самый затратный день: " + maxDay);
        System.out.println("Сумма затрат: " + maxExpense);
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
    }
}









