package hw;

/* SOLID-> S = Single Responsibility Principle */

public class Device extends Product {
    private final String model;
    private final int modelYear;
    private final double diagonal;
    private final Color color;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";

    public Device(ProductBuilder productBuilder) {
        //product
        this.lot = productBuilder.getLot();
        this.title = productBuilder.getTitle();
        this.description = productBuilder.getDescription();
        this.price = productBuilder.getPrice();
        this.remain = productBuilder.getRemain();
        //device
        this.model = productBuilder.getModel();
        this.modelYear = productBuilder.getModelYear();
        this.color = productBuilder.getColor();
        this.diagonal = productBuilder.getDiagonal();
    }

    @Override
    public String toString() {
        return  ANSI_PURPLE + "ЛОТ: " + lot + ANSI_RESET + "\n"
                + title + "\n"
                + description + "\n"
                + "Цвет: " + color + "\n"
                + "Экран: " + diagonal + "\n"
                + "Цена: " + price + "руб.\n"
                + "Модель:" + model + "\n"
                + "Модельный год: " + modelYear + "\n"
                + "Осталось: " + remain + " шт.\n"
                + "------------------\n" ;
    }
}
