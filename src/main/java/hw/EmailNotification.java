package hw;

public class EmailNotification implements Notifier{
    @Override
    public void sendNotify(String msg) {
        System.out.println(msg);
    }
}
