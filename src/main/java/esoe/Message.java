package esoe;

import java.util.Date;

public class Message {
    private String type;//тип сообщения: действия пользователя, ошибки программы, ход выполнения программы
    private String content;//содержание сообщения
    private int id;//идентификатор сообщения, номер

    public Message(){}

    //создаем новое сообщение с определенным контентом
    public void setContent(String s){
        this.content = s;
    }

    public void setType(String s){
        this.type = s;
    }

    public void setId(int i){
        this.id = i;
    }

    public String getType(){
        return this.type;
    }

    public String getContent(){
        return this.content;
    }

    public int getId(){
        return this.id;
    }

    public String[] mesToString(){
        String[] s = new String[3];
        s[0] = Integer.toString(this.id);
        s[1] = this.getContent();
        s[2] = this.getType();
        return s;

    }

}
