import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<ItemOrder> itens = new ArrayList<>();

    public void addItemToOrder(ItemOrder item) {
        itens.add(item);
    }

    public double getTotalPrice() {
        double total = 0;

        for (ItemOrder item : itens) {
            total += item.getPrice();
        }

        return total;
    }
}