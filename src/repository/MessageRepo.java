package repository;

import entity.Message;

import java.util.HashMap;
import java.util.Map;

public class MessageRepo {
    public static Map<Long, Message> messageMap = new HashMap<>();
}
