package entity;

public class Message {

    private Long id;
    private String text;
    private String topicName;

    public Message(Long id, String text, String topicName) {
        this.id = id;
        this.text = text;
        this.topicName = topicName;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTopicName() {
        return topicName;
    }
}
