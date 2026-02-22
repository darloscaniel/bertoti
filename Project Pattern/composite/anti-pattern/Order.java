    import java.util.ArrayList;
    import java.util.List;
    
    class Order {
    
        List<Object> itens = new ArrayList<>();

    double getTotal() {
        double total = 0;

        for (Object item : itens) {

            if (item instanceof Product) {
                total += ((Product) item).getPrice();
            }

            if (item instanceof Combo) {
                total += ((Combo) item).getPrice();
            }
        }

        return total;
    }
}