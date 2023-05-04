import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Введите количество гостей: ");
        int people = 0;
        double shet = 0.00;
        while (true) {

            try {

                Scanner scanner = new Scanner(System.in);
                people = scanner.nextInt();

                if (people > 1) {
                    System.out.println("Количество гостей: " + people + ". Перейдем к заказу и поделим счет!");
                    break;
                }
                if (people == 1) {
                    System.out.println("Количество гостей: " + people + ". Нет смысла делить счет(");
                }
                if (people <= 0) {
                    System.out.println("Введено неверное количество гостей. Введите число больше 1");
                }
                System.out.println("Введите количество гостей: ");
            } catch (final InputMismatchException e) {
                System.out.println("Введено некорректное значение\nВведите количество гостей: ");

            }

        }

        if (people > 1) {
            Calculature calculature = new Calculature();
            calculature.Calculature();
            System.out.println("Итоговая сумма заказа: " + calculature.allCost);
            shet = calculature.allCost / people;
            String result = String.format("%.2f",shet);
            if ((int) shet % 100 >= 11 && (int) shet % 100 <= 14) {
                System.out.println("Счет на каждого гостя равен: " + result + " рублей");
            } else {
                // если условие выше не сработало, то проверяем остаток от 10

                switch ((int) shet % 10) {
                    case 1:
                        System.out.println("Счет на каждого гостя равен: " + result + " рубль");
                        break;
                    case 2:
                    case 3:
                    case 4:
                        System.out.println("Счет на каждого гостя равен: " + result + " рубля");
                        break;
                    default:
                        System.out.println("Счет на каждого гостя равен: " + result + " рублей");
                        break;
                }
            }
        }
    }

    public static class Calculature {
        double cost = 0.00;
        String product = "";
        String allProducts = "";
        double allCost = 0.00;
        void Calculature() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите название товара: ");

            while(true) {

                product = scanner.nextLine();

                if(product.equalsIgnoreCase("завершить")) {
                    System.out.println("Подсчет товаров завершен!");
                    break;
                } else {
                    allProducts = allProducts + "\n " + product;
                    System.out.println("Введите стоимость товара: ");
                    while(true) {
                        try {
                            Scanner sc = new Scanner(System.in);
                            cost = sc.nextDouble();
                            if(cost > 0) {
                                allCost = allCost + cost;
                                break;
                            } else if(cost <= 0) {
                                System.out.println("Введены неверные данные. Стоимость товара должна превышать 1.");
                            }
                        } catch (final InputMismatchException e) {
                            System.out.println("Введены неверные данные. Стоимость товара не должна содержать буквы.");
                            continue;
                        }

                    }
                }
                System.out.println("Товар добавлен");
                System.out.println("Добавленные товары: " + allProducts);
                System.out.println("Итоговая сумма: " + allCost);
                System.out.println("Введите новый товар или напишите 'Завершить'");

            }
        }

    }
}