package entity;

public class Subscriber {
    private String userName;
    private String topicName;

    public Subscriber(String userName, String topicName) {
        this.userName = userName;
        this.topicName = topicName;
    }

    public String getUserName() {
        return userName;
    }

    public String getTopicName() {
        return topicName;
    }
}
