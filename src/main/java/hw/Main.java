package hw;
import java.util.Scanner;

public class Main {
    private static final Shop shop = new Shop();
    private static final ProductList productList = new ProductList();
    private static final Basket basket = new Basket();
    private static final Order order = new Order();
    private static final PrintService print = new PrintService();

    public static void main(String[] args) {

        //заполняем каталог
        productList.fillProductList();

        //здороваемся
        print.printMsg("Добро пожаловать в iPhone Store!");

        //показываем товары
        print.printArrayList(productList.getProducts());

        //предъявляем меню действий
        print.printShopActions(shop);

        //подключаем сканер
        Scanner scanner = new Scanner(System.in);
        while(true){
            int menuIndex = scanner.nextInt();
            if(menuIndex == 6){
                break;
            }
            switch (menuIndex) {
                case 1:
                    print.printArrayList(productList.getProducts());
                    print.printShopActions(shop);
                    break;
                case 2:
                    productList.sortByTitle();
                    print.printShopActions(shop);
                    break;
                case 3:
                    Basket.addToBasketMenu(scanner, productList, print);
                    print.printShopActions(shop);
                    break;
                case 4:
                    if(basket.getBasketProducts().isEmpty()){
                        print.printMsg("Ваша корзина пуста, давайте это исправим!");
                    } else {
                        print.printArrayList(basket.getBasketProducts());
                    }
                    print.printShopActions(shop);
                    break;
                case 5:
                    order.newOrderProcessing(basket, productList, print);
                    print.printShopActions(shop);
                    break;
                default:
                    print.printMsg("Кажется Вы ошиблись, попробуем ещё раз!");
                    print.printShopActions(shop);
                    break;
            }
        }
    }
}