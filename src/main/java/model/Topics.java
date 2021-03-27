package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topics {

    //create enum for these variable
    public  static final String ADMIN = "ADMIN";
    Map<String,Topic> topicList= null;

    public Topics() {
       this.topicList = new HashMap<>();
    }

    public String addTopics(Map<String,User> users,String userName,String topicName){

        if(topicList.containsKey(topicName)){
            return "TOPIC IS ALREADY EXIST IN SYSTEM";
        }
        if(users.get(userName)!=null && users.get(userName).getRole().equalsIgnoreCase(ADMIN)){
            Topic topic = new Topic(topicName);
            topicList.put(topicName,topic);
            return "ADDING TOPIC "+topicName+ " IN USER "+userName;
        }else{
            return "USER :: "+userName +" CANNOT DO ADD TOPIC  OPERATION";
        }
    }

    public String removeTopic(Map<String,User> users,String userName,String topicName){
        if(!topicList.containsKey(topicName)){
            return "TOPIC DOES NOT EXIST IN SYSTEM";
        }
        if(users.get(userName)!=null && users.get(userName).getRole().equalsIgnoreCase(ADMIN)){
            //for userUser which sub to this topic get removed
            for(Map.Entry<String,User> userEntry: users.entrySet()){
                User user = userEntry.getValue();
                user.getTopics().put(topicName,null);
            }
            topicList.put(topicName,null);
            return "USER :: " +userName + " REMOVED TOPIC "+topicName;
        }
        return "USER :: "+userName +" CANNOT DO REMOVE TOPIC  OPERATION";
    }


}
