package entity;

import java.util.*;

public class Topic {

    private String topicName;
    private Queue<Message> q;
    Set<String> subscribers;

    public Topic(String topicName) {
        this.topicName = topicName;
        this.q = new LinkedList<>();
        this.subscribers = new HashSet<>();
    }

    public String getTopicName() {
        return topicName;
    }

    public Queue<Message> getQ() {
        return q;
    }

    public void setQ(Queue<Message> q) {
        this.q = q;
    }

    public Set<String> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<String> subscribers) {
        this.subscribers = subscribers;
    }

}
