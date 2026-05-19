import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemOrder {

    private String name;
    private List<ItemOrder> itens = new ArrayList<>();

    public Combo(String name) {
        this.name = name;
    }

    public void addItem(ItemOrder item) {
        itens.add(item);
    }

    public void removeItem(ItemOrder item) {
        itens.remove(item);
    }

    @Override
    public double getPrice() {
        double total = 0;

        for (ItemOrder item : itens) {
            total += item.getPrice();
        }

        return total;
    }

    public String getName() {
        return name;
    }
}