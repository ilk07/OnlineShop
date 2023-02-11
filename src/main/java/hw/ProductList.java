package hw;

import java.util.ArrayList;

public class ProductList {
    public int lotCounter = 1;
    private ArrayList<Product> products = new ArrayList<>();

    public void fillProductList() {
        products.add(new ProductBuilder()
                .setTitle("iPhone 14")
                .setDescription("Новинка! Глубокий зеленый смартфон, непохожий на других - специально для вашей индивидуальности 0")
                .setPrice(120_000.00)
                .setRemain(10)
                .setDiagonal(6.1)
                .setColor(Color.GREEN)
                .setModelYear(2021)
                .setModel("Iphone 14")
                .setLot(lotCounter++)
                .build());
        products.add(new ProductBuilder()
                .setTitle("iPhone 14 ProMax")
                .setDescription("Нежный розовый для её восхитительных фото 1")
                .setPrice(120_000.00)
                .setRemain(10)
                .setColor(Color.PINK)
                .setModel("Iphone 14 PLUS")
                .setModelYear(2022)
                .setLot(lotCounter++)
                .setDiagonal(6.7)
                .build());
        products.add(new ProductBuilder()
                .setTitle("iPhone 14 PLUS")
                .setDescription("Топовый и строгий чёрный для настоящих ценителей качества 2")
                .setPrice(140_000.00)
                .setRemain(8)
                .setModel("Iphone 14")
                .setModelYear(2022)
                .setColor(Color.BLACK)
                .setLot(lotCounter++)
                .setDiagonal(6.7)
                .build());
        products.add(new ProductBuilder()
                .setTitle("iPhone 14 PLUS")
                .setDescription("Шикарный матовый белый с топовой камерой 48MP 3")
                .setPrice(135_000.00)
                .setRemain(4)
                .setModel("Iphone 14")
                .setModelYear(2022)
                .setColor(Color.WHITE)
                .setLot(lotCounter++)
                .setDiagonal(6.7)
                .build());
    }

    public Product getByLotNumber(int lotNum) {
        for (Product product : products) {
            if (product.lot == lotNum) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void sortByTitle() {
        products.stream()
                .sorted(new ProductsComparator())
                .forEach(
                        System.out::println
                );
    }

}


