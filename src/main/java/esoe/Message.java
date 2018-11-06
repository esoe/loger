package esoe;

public class Message {
    private int id;
    private String type;
    private String content;

    public Message(){}
    public void setId(int id){ this.id = id; }
    public void setType(String type){ this.type = type; }
    public void setContent(String content){ this.content = content; }
    public int getId(){ return this.id; }
    public String getType(){ return this.type; }
    public String getContent(){ return this.content; }
    public String messageToString(){
        String s = "";
        s = s + this.getId() + " " + this.getType() + " " + this.getContent();
        return  s;
    }
}
