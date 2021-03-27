package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {

    private  static  Users userInstance=null;

    public static  Users getInstance(){
        if(userInstance==null)
            userInstance = new Users();
        return userInstance;
    }

    public static final String ADMIN="ADMIN";
    Map<String,User> users;


    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public Users() {
        this.users = new HashMap<>();
    }


    public String addUser(String userName,String userRole){
        User user = new User(userName,userRole);
        this.users.put(userName,user);
        return "USER HAS ADDED INTO SYSTEM WITH NAME :: " +userName + "AND ROLE "+ userRole;
    }

    public String removeUser(String removeUserName,String adminUserName){
        if(users.get(adminUserName)!=null && users.get(adminUserName).getRole().equalsIgnoreCase(ADMIN)){
            if(users.get(removeUserName)!=null){
                users.put(removeUserName,null);
                return "USER :: "+removeUserName +" IS REMOVE BY ::" + adminUserName;
             }else{
                return "USER :: "+removeUserName +" DOES NOT EXIST" ;
            }
        }else{
            return "USER :: "+adminUserName +" DOES NOT EXIST" ;
        }
    }

    String subscribeTopicForUser(String userName,String topicName){

        if(users.get(userName)!=null){
            User user = users.get(userName);
            Topic topic = new Topic(topicName);
            user.getTopics().put(topicName,topic);
            return "ADDING TOPIC "+topicName+ " IN USER "+userName;
        }else{
            return "USER :: "+userName + " DOES NOT EXIST ";
        }
    }

    public List<Topic> viewSubscribeTopic(Notification notification ,String userName){

        Map<String,Topic> topics = this.users.get(userName).getTopics();
        List<Topic> topicList = new ArrayList<>();
        for(Payload payload:notification.getPayloadList()){
            if(topics.get(payload.getTopic().getTopicName())!=null)
                topicList.add(payload.getTopic());
        }
        return topicList;
    }


}
