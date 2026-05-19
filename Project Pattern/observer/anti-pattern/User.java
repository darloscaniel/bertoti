public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void receiveNotification(String videoTitle) {
        System.out.println(name + " received notification: " + videoTitle);
    }
}