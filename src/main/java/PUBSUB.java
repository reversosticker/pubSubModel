import model.Notification;
import model.Topics;
import model.User;
import model.Users;

import java.util.Scanner;

public class PUBSUB {

    public static void main(String[] args) {

        Topics topics = new Topics();
       boolean flag = true;
        while(flag){
            System.out.println("1 for add User");
            System.out.println("2 for add Topic");
            System.out.println("3 for Subscribe Topic");
            System.out.println("4 for view subscribe topic");
            System.out.println("5 postEventBody");
            System.out.println("remove User");
            System.out.println("remove Topic");

            Scanner scanner = new Scanner(System.in);
            int opeation = scanner.nextInt();
            switch (opeation){
                case 1:
                    System.out.println("Please enter userName and userRole");
                    String userName = scanner.next();
                    String userRole = scanner.next();
                    System.out.println(Users.getInstance().addUser(userName,userRole));
                    break ;
                case 2:
                    System.out.println("Please enter userName and userRole");
                    userName = scanner.next();
                    String topicName = scanner.next();
                    System.out.println(Users.getInstance().);
                    break;
                case 3:
                    System.out.println("Please enter userName and  topicName to add");
                    userName = scanner.next();
                    topicName = scanner.next();
                    System.out.println(topics.addTopics(Users.getInstance().getUsers(),userName,topicName));

                    break;
                case 4:
                    System.out.println("Please enter userName");
                    userName = scanner.next();
                    Users.getInstance().viewSubscribeTopic(Notification.getInstnce(),userName);
                    break;
                case 5:
                    System.out.print("Please enter message body Note** message body is of json structure");
                    String messageBody = scanner.next();
                    System.out.println(Notification.getInstnce().postEvent(messageBody));
                    break;
                case 6:
                    System.out.println("Please enter userOne and userTwo");
                    String userOne = scanner.next();
                    String userTwo = scanner.next();
                    System.out.println(Users.getInstance().removeUser(userOne,userTwo));
                    break;
                case 7:
                    System.out.println("Please enter userName and  topicName");
                    userName = scanner.next();
                    topicName = scanner.next();
                    System.out.println(topics.removeTopic(Users.getInstance().getUsers(),userName,topicName));
                default:
                    flag=false;
                    break;
            }

        }


    }

}
