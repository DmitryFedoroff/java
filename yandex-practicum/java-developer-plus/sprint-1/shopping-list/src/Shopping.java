import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {
        String[] shoppingList = new String[8];
        int productCount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вас приветствует список покупок!");

        while (true) {
            System.out.println("\nВыберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();
            scanner.nextLine();

            if (actionNumber == 1) {

            } else if (actionNumber == 2) {

            } else if (actionNumber == 3) {

            } else if (actionNumber == 4) {

            } else {
                System.out.println("\nНеизвестная команда!");
            }
        }
    }
}
