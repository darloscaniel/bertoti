public class AdaptadorSDparaUSB implements Usb {

    private CartaoSD cartaoSD;

    public AdaptadorSDparaUSB(CartaoSD cartaoSD) {
        this.cartaoSD = cartaoSD;
    }

    @Override
    public void conectarUsb() {
        cartaoSD.conectarCartaoSD();
    }
}
