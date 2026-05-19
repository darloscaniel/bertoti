public interface Channel {
    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);
    
    void notifySubscribers();
}