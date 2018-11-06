package esoe;

import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel {
    public String[] header = {"id", "type", "message"};
    public Object[][] data;// = new Object[0][header.length];

    //переменные сообщения
    public Message message = new Message();

    public  Model(){}
    //инициация модели по названию (типу логера)
    public Model(String name){
        this.message.setType(name);
        this.message.setId(0);
        this.message.setContent("");
    }
    public Model(Message m){
        this.message = m;
    }

    //добавляем строку в модель
    public void message(String s){
        Loger.add(this, s);
        fireTableDataChanged();
    }

    //возвращает строку сообщения
    public String getMessage(){
        String s = "";
        s = message.getId() + " " + message.getType() + " " + message.getContent() + "\n";
        return s;
    }

    public int getColumnCount() {
        return this.header.length;
    }

    public int getRowCount() {
        return this.data.length;
    }

    public Object getValueAt(int row, int col) {
        return this.data[row][col];
    }

    public Model getModel(){
        return this;
    }


}
