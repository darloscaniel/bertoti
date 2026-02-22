public class Main {

    public static void main(String[] args) {

        Product teclado = new Product("Teclado", 200);
        Product mouse = new Product("Mouse", 100);

        Combo combo = new Combo();
        combo.add(teclado);
        combo.add(mouse);

        Order pedido = new Order();

        pedido.itens.add(teclado);
        pedido.itens.add(combo);

        double total = pedido.getTotal();

        System.out.println("Total: " + total);
    }
}