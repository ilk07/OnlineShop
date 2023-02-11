package hw;

import java.util.ArrayList;

public class Shop {

    private final ArrayList<String> actions = new ArrayList<String>() {
        {
            add("Посмотреть все iPhone в продаже");
            add("Сортировать по названию");
            add("Добавить iPhone в корзину");
            add("Просмотреть корзину");
            add("Оформить заказ");
            add("Выйти");
        }
    };

    public ArrayList<String> getActions() {
        return actions;
    }

}
