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
                System.out.print("\nВведите название товара без пробелов, используя символ подчёркивания для разделения слов, например: \"кокосовое_молоко\": ");
                String productName = scanner.next();

                boolean isProductInList = false;
                for (int i = 0; i < productCount; i++) {
                    if (shoppingList[i].equals(productName)) {
                        isProductInList = true;
                        break;
                    }
                }

                if (!isProductInList) {
                    if (productCount >= shoppingList.length) {
                        String[] expandedShoppingList = new String[shoppingList.length * 2];
                        System.arraycopy(shoppingList, 0, expandedShoppingList, 0, shoppingList.length);
                        shoppingList = expandedShoppingList;
                    }

                    shoppingList[productCount] = productName;
                    productCount++;
                    System.out.println("\nТовар \"" + productName + "\" добавлен в список под номером " + productCount + ".");
                } else {
                    System.out.println("\nТовар \"" + productName + "\" уже есть в списке.");
                }
            } else if (actionNumber == 2) {
                if (productCount == 0) {
                    System.out.println("\nСписок покупок пуст.");
                } else {
                    System.out.println("\nСписок покупок:");
                    for (int i = 0; i < productCount; i++) {
                        System.out.println((i + 1) + ". " + shoppingList[i]);
                    }
                }
            } else if (actionNumber == 3) {
                productCount = 0;
                System.out.println("\nСписок покупок очищен.");
            } else if (actionNumber == 4) {
                System.out.println("\nРабота программы завершена.");
                break;
            } else {
                System.out.println("\nНеизвестная команда!");
            }
        }
    }
}
