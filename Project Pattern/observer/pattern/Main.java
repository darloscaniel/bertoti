public class Main {
    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel();

        User john = new User("John");
        User mary = new User("Mary");

        channel.subscribe(john);
        channel.subscribe(mary);

        channel.publishVideo("Understanding Observer Pattern");
    }
}