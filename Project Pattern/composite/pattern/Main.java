public class Main {
    public static void main(String[] args) {

        Product teclado = new Product("Teclado", 200);
        Product mouse = new Product("Mouse", 100);

        Combo kitPerifericos = new Combo("Kit Periféricos");
        kitPerifericos.addItem(teclado);
        kitPerifericos.addItem(mouse);

        Product monitor = new Product("Monitor", 800);

        Combo superCombo = new Combo("Super Combo");
        superCombo.addItem(kitPerifericos);
        superCombo.addItem(monitor);

        Order pedido = new Order();
        pedido.addItemToOrder(superCombo);

        System.out.println("Total: " + pedido.getTotalPrice());
    }
}