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
    }
    public void tableChanged(TableModelEvent e) {
        //int firstRow = e.getFirstRow();
        //int lastRow = e.getLastRow();
        //int index = e.getColumn();
        if (e.getType() == TableModelEvent.UPDATE){
            String s = this.model.getMessage();
            ta.append(s);
        }
        /**
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
         */
    }

}
