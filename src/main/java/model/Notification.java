package model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Notification {

   private static Notification notification = null;
   public static Notification getInstnce(){
       if(notification==null)
       {
           notification = new Notification();
       }
       return  notification;
   }

   private  Notification(){
       payloadList = new ArrayList<>();
   }

    public List<Payload> getPayloadList() {
        return payloadList;
    }

    List<Payload> payloadList;

    String postEvent(Payload payload){
        this.payloadList.add(payload);
        return "ADD MESSAGE BODY IN NOTIFICATION SYSTEM";
    }

    public  String postEvent(String payloadStr){
        Gson gson = new Gson();
        Payload payload =  gson.fromJson(payloadStr,Payload.class);
        return postEvent(payload);
    }

}
