package esoe;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ListModel extends AbstractTableModel {
    ArrayList<String> header;
    ArrayList<ArrayList<Object>> data;
    ArrayList<Object> mes;//id, type, string

    public ListModel(int id, String type, String mes){

    }

    public void message(String s){}

    public String getValueAt(int row, int col){
        String s = "";
        return s;
    }
    public int getRowCount(){
        int row = 0;
        return row;
    }
    public int getColumnCount(){
        return 3; //id, type, mes
    }
}
