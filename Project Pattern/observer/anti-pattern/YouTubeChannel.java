public class YouTubeChannel {

    private User user1;
    private User user2;

    public YouTubeChannel(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public void publishVideo(String title) {
        System.out.println("New video published: " + title);

        // Canal chamando diretamente usuários específicos
        user1.receiveNotification(title);
        user2.receiveNotification(title);
    }
}