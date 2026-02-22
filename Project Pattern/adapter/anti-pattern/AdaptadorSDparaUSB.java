class AdaptadorSDparaUSB extends CartaoSD implements Usb {

    @Override
    public void conectarUsb() {
        System.out.println("Adaptador: convertendo SD para USB...");
        super.conectarCartaoSD();
        System.out.println("Adaptador: conexão USB estabelecida.");
    }
}
