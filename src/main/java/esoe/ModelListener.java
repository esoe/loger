package esoe;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class ModelListener implements TableModelListener {
    ModelLoger model;
    JTextArea ta;
    ModelListener(ModelLoger model, JTextArea ta) {
        this.ta = ta;
        this.model = model.getModel();
    }
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE){
            String s = this.model.getMessage();
            ta.append(s);
        }
    }

}
