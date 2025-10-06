package observer.pattern.java;

public class Main {
    public static void main(String[] args) {
        GroupChat grupo = new GroupChat();

        User u1 = new User("Carlos");
        User u2 = new User("Ana");
        User u3 = new User("Pedro");

        grupo.addUser(u1);
        grupo.addUser(u2);
        grupo.addUser(u3);

        grupo.sendMessage("Olá pessoal!");
    }
}
