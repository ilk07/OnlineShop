package hw;

import java.util.Comparator;

public class ProductsComparator implements Comparator<Product> {
    @Override
    public int compare(Product a, Product b) {
        return a.title.toUpperCase().compareTo(b.title.toUpperCase());
    }
}

