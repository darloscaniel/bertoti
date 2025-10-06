package observer.antipattern.java;

public class User {
    private String name;

    public User(String name) { this.name = name; }

    public void notify(String msg) {
        System.out.println(name + " received: " + msg);
    }
}
