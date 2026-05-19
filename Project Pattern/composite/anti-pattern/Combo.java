import java.util.ArrayList;
import java.util.List;

public class Combo {

    List<Product> produtos = new ArrayList<>();

    void add(Product p) {
        produtos.add(p);
    }

    double getPrice() {
        double total = 0;

        for (Product p : produtos) {
            total += p.getPrice();
        }

        return total;
    }
} 
