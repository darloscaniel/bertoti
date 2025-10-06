package observer.antipattern.java;

public class Main {
    public static void main(String[] args) {
        User u1 = new User("Carlos");
        User u2 = new User("Ana");

        GroupChat group = new GroupChat(u1, u2);

        group.sendMessage("Oi galera!");
    }
}
