public class Main {
    public static void main(String[] args) {

        User john = new User("John");
        User mary = new User("Mary");

        YouTubeChannel channel = new YouTubeChannel(john, mary);

        channel.publishVideo("Understanding Anti-Pattern");
    }
}