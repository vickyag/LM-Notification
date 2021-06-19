package service;

import entity.Message;
import entity.Topic;
import repository.TopicRepo;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ProcessMessages extends Thread {

    public void run(){
        System.out.println("Consumer started...");
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(Map.Entry<String, Topic> entry : TopicRepo.topicMap.entrySet()){
                Topic topic = entry.getValue();
                Queue<Message> q = topic.getQ();
                if(q.size() != 0){
                    System.out.println("Processing Messages");
                    while(!q.isEmpty()){
                        Message message = q.remove();
                        Set<String> subscribers = topic.getSubscribers();
                        for(String subscriber : subscribers){
                            System.out.println("{");
                            System.out.println("topic: " + topic.getTopicName());
                            System.out.println("message: " + message.getText());
                            System.out.println("sentTo: " + subscriber);
                            System.out.println("}");
                        }
                    }
                    System.out.println("messages successfully processed");
                }
                topic.setQ(q);
            }
        }
    }

}
