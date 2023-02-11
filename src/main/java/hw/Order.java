package hw;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Order implements Ordering, Delivery {

    private String customer;
    private double sum;
    private double total;
    private String address;
    private String phone;
    private String mail;
    private final Date orderDate = new Date();
    private double deliveryTotal;
    private EmailNotification emailNotification = new EmailNotification();

    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");


    public void newOrderProcessing(Basket basket, ProductList productList, PrintService print) {

        if (Basket.basketProducts.isEmpty()) { //если в корзине пусто

            System.out.println("Корзина пуста, выберите товар, добавьте в корзину и мы сможем оформить заказ!");
        } else { //если что-то есть
            //показываем корзину
            print.printArrayList(basket.getBasketProducts());

            //подключаем сканер
            Scanner orderScanner = new Scanner(System.in);
            System.out.println("Введите контактные данные для оформления заказа");

            while (true) {
                print.printMsg("Как Вас зовут? Фамилия имя отчество (если есть)");
                customer = orderScanner.nextLine();

                print.printMsg("Контактный телефон / укажите номер телефона в любом формате");
                phone = orderScanner.nextLine();

                print.printMsg("Введите Ваш E-mail");
                mail = orderScanner.nextLine();

                print.printMsg("Куда повезем заказ? Введите адрес");
                address = orderScanner.nextLine();

                // обрабатываем остатки
                for (BasketProduct basketProduct : basket.basketProducts) {
                    for (Product product : productList.getProducts()) {
                        if (product.equals(basketProduct.product)) {
                            int newRemain = product.remain - basketProduct.count;
                            if (newRemain >= 0) {
                                //меняем остаток
                                product.setRemain(newRemain);
                                sum += basketProduct.price * basketProduct.count;
                                print.printMsg("Товар "
                                        + basketProduct.product.title
                                        + " добавлен в заказ - "
                                        + basketProduct.count + " шт.");
                            } else {
                                print.printMsg("Товар " + product.title + " не добавлен в заказ \n" +
                                        + basketProduct.count + " шт. нет в наличии");
                            }
                            break;
                        }
                    }
                }

                deliveryTotal = getDeliveryCost();
                total = sum + deliveryTotal;
                createOrder();
                basket.clearBasket();
                emailNotification.sendNotify("Отправили данные заказа Вам на почту!");
                break;
            }
        }
    }
    @Override
    public void createOrder() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Заказ от " + formatter.format(orderDate) +
                "\nПокупатель: " + customer +
                "\nАдрес доставки: " + address +
                "\nТелефон: " + phone +
                "\nE-mail: " + mail +
                "\nСтоимость товаров: " + sum + " руб." +
                "\nДоставка: " + deliveryTotal + " руб." +
                "\nИтого, стоимость заказа: " + total + " руб.";
    }


    @Override
    public double getDeliveryCost() {
        return 0;
    }

}
