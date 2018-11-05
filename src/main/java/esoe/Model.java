package esoe;



import esoe.model.ArrScheme;

import javax.swing.table.AbstractTableModel;
import java.awt.event.AdjustmentEvent;
import java.util.Date;

public class Model extends AbstractTableModel {
    public String[] header = {"id", "type", "message"};
    public Object[][] data;// = new Object[0][header.length];

    //переменные сообщения
    public int id;
    public String type;
    public String mes;

    public Model(int id, String type, String mes){

        this.id = id;
        this.type = type;
        this.mes = mes;
        this.data = new Object[1][3];
        this.data[0][0] = this.id;
        this.data[0][1] = this.type;
        this.data[0][2] = this.mes;

    }
   // AdjustmentEvent event = new
    //добавляем строку в модель
    public void message(String s){
        Loger.add(this, s);
        fireTableDataChanged();
    }

    public String getMessage(){
        String s = "";
        s = id + " " + type + " " + mes + "\n";
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


    //добавляем значения переменных сообщения к массиву data
    /**
    public void add(){
        Object[][] d;
        if(data == null){
            d = new Object[1][header.length];
            d[0][0] = id;
            d[0][1] = type;
            d[0][2] = mes;
            System.out.println("Назначение нулевой строки");
        }else {
            d = new Object[data.length+1][header.length];
            int i = 0;
            while (i < data.length){
                int j = 0;
                while (j < header.length){
                    d[i][j] = data[i][j];
                    j++;
                }
                i++;
            }
            d[data.length][0] = id;
            d[data.length][1] = type;
            d[data.length][2] = mes;
            System.out.println(type);
        }

        data = new Object[d.length][header.length];
        int i = 0;
        while (i < data.length){
            int j = 0;
            while (j < header.length){
                d[i][j] = data[i][j];
                j++;
            }
            i++;
        }
    }
     */

    //возвращаем данные модели в виде текста для отображения в интерфейсе пользователя
    /**
    public String getText(){
        String s = "";
        int i = 0;
        while (i < header.length){
            s = s + header[i] + "\t";
            i++;
        }
        s = s + "\n";

        i = 0;
        while (i < data.length){
            int j = 0;
            while (j < header.length){
                s = s + data[i][j] + "\t";
                j++;
            }
            s = s + "\n";
            i++;
        }

        return s;
    }
     */

}
