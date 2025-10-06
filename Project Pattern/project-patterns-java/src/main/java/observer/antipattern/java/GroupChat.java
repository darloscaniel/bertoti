package observer.antipattern.java;

class GroupChat {
    private User user1;
    private User user2;

    public GroupChat(User u1, User u2) {
        this.user1 = u1;
        this.user2 = u2;
    }

    public void sendMessage(String msg) {
        System.out.println("Mensagem no grupo: " + msg);
        user1.notify(msg); 
        user2.notify(msg); 
    }
}