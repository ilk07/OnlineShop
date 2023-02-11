package hw;

public class BasketProduct {
    protected Product product;
    protected double price;
    protected int count;

    public BasketProduct(Product product, int count) {
        this.product = product;
        this.price = product.price;
        this.count = count;
    }


    @Override
    public String toString() {
        return
                product.title + " | " + count + " шт. | " + price + "руб.\n";
    }
}
