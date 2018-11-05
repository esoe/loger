package esoe;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class ModelListener implements TableModelListener {
    Model model;
    JTextArea ta;
    ModelListener(Model model, JTextArea ta) {
        this.ta = ta;

        this.model = model.getModel();
        System.out.println("слушатель запустился:");//да
        int i = 0;
        while(i < this.model.getColumnCount()){
            System.out.print(this.model.header[i] + " ");
            i++;
        }
        System.out.print("\n");

        i = 0;
        while (i < this.model.getRowCount()){
            int j = 0;
            while (j < this.model.getColumnCount()){
                System.out.print(this.model.data[i][j] + " ");
                j++;

            }
            i++;
            System.out.print("\n");

        }

    }
    public void tableChanged(TableModelEvent e) {
        int firstRow = e.getFirstRow();
        int lastRow = e.getLastRow();
        int index = e.getColumn();
        switch (e.getType()) {
            case TableModelEvent.INSERT:
                System.out.println("успех! 1");
                break;
            case TableModelEvent.UPDATE:
                //System.out.println("успех! 2");
                String s = this.model.getMessage();


                ta.append(s);
                break;
            case TableModelEvent.DELETE:
                System.out.println("успех! 3");
                break;
        }
    }

}
