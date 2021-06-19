package service;

import entity.Message;
import entity.Topic;
import repository.MessageRepo;
import repository.TopicRepo;

import java.util.Queue;

public class MessageService {

    public String publishMessage(Long id, String text, String topicName) throws Exception {
        if(MessageRepo.messageMap.getOrDefault(id, null) != null) {
            throw  new Exception("Duplicate Message Id found, could not publish");
        }

        Topic topic = TopicRepo.topicMap.getOrDefault(topicName, null);
        if(topic == null){
            throw  new Exception("No such topic found");
        }

        Message message = new Message(id, text, topicName);
        MessageRepo.messageMap.put(id, message);
        Queue<Message> q = topic.getQ();
        q.add(message);
        topic.setQ(q);

        return "message successfully published";
    }


}
