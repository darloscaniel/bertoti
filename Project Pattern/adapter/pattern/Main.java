public class Main {
    public static void main(String[] args) {

        // Cartão SD da câmera
        CartaoSD cartaoSD = new CartaoSD();

        // Adaptador
        Usb adaptador = new AdaptadorSDparaUSB(cartaoSD);

        // Computador só entende USB
        adaptador.conectarUsb();
    }
}
