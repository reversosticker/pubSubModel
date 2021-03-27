package model;

public class Payload {

    String id;
    Topic Topic;
    String Text;

    public Payload(String id, model.Topic topic, String text) {
        this.id = id;
        Topic = topic;
        Text = text;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public model.Topic getTopic() {
        return Topic;
    }

    public void setTopic(model.Topic topic) {
        Topic = topic;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
