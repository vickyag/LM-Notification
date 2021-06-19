package driver;

import constant.UserRole;
import service.MessageService;
import service.ProcessMessages;
import service.TopicService;
import service.UserService;

import java.util.Scanner;

public class Driver {

    private static MessageService messageService = new MessageService();
    private static ProcessMessages processMessages = new ProcessMessages();
    private static TopicService topicService = new TopicService();
    private static UserService userService = new UserService();

    public static void main(String... s) {

        processMessages.start();
        Scanner sc = new Scanner(System.in);
        String command;
        String userName, role, topicName, output, text;
        Long id;
        while(true){
            try {
                command = sc.next();
                switch (command){
                    case "addUser":
                        userName = sc.next();
                        role = sc.next();
                        UserRole userRole = null;
                        if(role.equals("USER")){
                            userRole = UserRole.USER;
                        }else if(role.equals("ADMIN")){
                            userRole = UserRole.ADMIN;
                        }
                        output = userService.addUser(userName, userRole);
                        System.out.println("Operation Success: " + output);;
                        break;

                    case "addTopic":
                        topicName = sc.next();
                        userName = sc.next();
                        output = topicService.addTopic(topicName, userName);
                        System.out.println("Operation Success: " + output);;
                        break;

                    case "subscribeTopic":
                        topicName = sc.next();
                        userName = sc.next();
                        output = topicService.subscribe(topicName, userName);
                        System.out.println("Operation Success: " + output);;
                        break;

                    case "publishMessage":
                        id = sc.nextLong();
                        topicName = sc.next();
                        text = sc.next();
                        output = messageService.publishMessage(id, text, topicName);
                        System.out.println("Operation Success: " + output);;
                        break;

                    default:
                        System.out.println("Invalid command");
                        break;
                }
            } catch (Exception e){
                System.out.println("Operation FAILED: " + e.getMessage());
            }
        }

    }
}


