package hw;

public class ProductBuilder {
    private int lot; //номер лота
    private String title; //название
    private String description; //описание
    private double price; //цена
    private int remain; //остаток

    private String model; //модель
    private Color color; //цвет
    private int modelYear; //год выпуска модели

    private double diagonal; //диагональ

    public ProductBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ProductBuilder setDiagonal(double diagonal) {
        this.diagonal = diagonal;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setModelYear(int modelYear) {
        this.modelYear = modelYear;
        return this;
    }

    public ProductBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public ProductBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public ProductBuilder setRemain(int remain) {
        this.remain = remain;
        return this;
    }

    public ProductBuilder setLot(int lot) {
        this.lot = lot;
        return this;
    }

    public int getLot() {
        return lot;
    }

    public String getTitle() {
        return title;
    }

    public int getModelYear() {
        return modelYear;
    }

    public Color getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getRemain() {
        return remain;
    }

    public Product build() {
        return new Device(this);
    }

}
