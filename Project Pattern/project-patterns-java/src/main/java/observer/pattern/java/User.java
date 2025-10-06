package observer.pattern.java;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String mensagem) {
        System.out.println("Notificação para " + name + ": " + mensagem);
    }
    
}
