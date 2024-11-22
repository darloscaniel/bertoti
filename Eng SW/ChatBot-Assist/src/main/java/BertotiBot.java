import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class BertotiBot {
    public static void main(String[] args) {
        String botToken = "7631154941:AAF2LPz1awn1OHc6e0nmqg2c61zqcBwwoDc";
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new TelegramBot(botToken));
            System.out.println("BertotiBot successfully started!");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
