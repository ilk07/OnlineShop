package hw;

import java.util.ArrayList;
import java.util.Scanner;

public class Basket {
    public static ArrayList<BasketProduct> basketProducts = new ArrayList<>();

    public ArrayList<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void clearBasket() {
        basketProducts.clear();
    }

    public static void addToBasketMenu(Scanner scanner, ProductList productList, PrintService print) {
        //меню корзины
        while (true) {
            print.printMsg("Введите номер лота для добавления в корзину:");
            int lotNum = scanner.nextInt();
            if (lotNum == 0) break;

            Product productToAdd = productList.getByLotNumber(lotNum);

            if (productToAdd != null) {
                int remain = productToAdd.getRemain();
                if (remain > 0) {
                    print.printMsg("На складе есть " + remain + " шт. Сколько хотите заказать?");
                    int count = scanner.nextInt();
                    if (count > 0) {
                        if (count > remain) {
                            print.printMsg("Извините, столько у нас нет, мы не сможем добавить в корзину\n");
                            break;
                        } else {
                            basketProducts.add(new BasketProduct(productToAdd, count));
                            print.printMsg("Товар добавлен в корзину!");
                            print.printArrayList(basketProducts);

                            break;
                        }
                    } else {
                        print.printMsg("К сожалению, нельзя заказать 'ничего'\n");
                        break;
                    }
                } else {
                    print.printMsg("К сожалению, товар закончился\n");
                    break;
                }
            } else {
                print.printMsg("Лот не найден :(");
                break;
            }
        }

    }

}
