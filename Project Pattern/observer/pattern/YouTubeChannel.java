import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Channel {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestVideo;

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishVideo(String title) {
        this.latestVideo = title;
        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(latestVideo);
        }
    }
}