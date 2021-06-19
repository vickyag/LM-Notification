package service;

import constant.UserRole;
import entity.Subscriber;
import entity.Topic;
import entity.User;
import repository.SubscribersRepo;
import repository.TopicRepo;
import repository.UserRepo;

import java.util.Set;

public class TopicService {

    public String addTopic(String topicName, String userName) throws Exception {

        User user = UserRepo.userMap.getOrDefault(userName, null);
        if(user == null){
            throw new Exception("Unknown user, cannot create topic");
        }
        if(user.getUserRole().equals(UserRole.USER)){
            throw new Exception("only admins can add topics");
        }

        Topic topic = new Topic(topicName);
        TopicRepo.topicMap.put(topicName, topic);
        return "topic successfully added";
    }

    public String subscribe(String topicName, String userName) throws Exception {
        Topic topic = TopicRepo.topicMap.getOrDefault(topicName, null);
        if(topic == null){
            throw new Exception("topic not found, plz ask admin to add this topic");
        }
        User user = UserRepo.userMap.getOrDefault(userName, null);
        if(user == null){
            throw new Exception("user not found, plz add user first");
        }

        Subscriber subscriber = new Subscriber(userName, topicName);
        SubscribersRepo.subscribersMap.put(userName, subscriber);
        Set<String> subscribers = topic.getSubscribers();
        subscribers.add(userName);
        topic.setSubscribers(subscribers);

        return "topic successfully subscribed";
    }


}
