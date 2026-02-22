public class Main {
    public static void main(String[] args) {

        Usb usb = new AdaptadorSDparaUSB();

        System.out.println("--- 1. Uso correto (como USB) ---");
        usb.conectarUsb();

        System.out.println("\n--- 2. Vazamento da abstração ---");

        if (usb instanceof AdaptadorSDparaUSB) {
            AdaptadorSDparaUSB adaptadorReal =
                    (AdaptadorSDparaUSB) usb;

            // Método que NÃO existe na interface USB!
            adaptadorReal.formatarCartao();
        }
    }
}
