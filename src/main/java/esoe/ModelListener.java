package esoe;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;



public class ModelListener implements TableModelListener {
    Model model;
    ModelListener(Model model) {
        this.model = model;
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
                System.out.println("успех! 2");
                break;
            case TableModelEvent.DELETE:
                System.out.println("успех! 3");
                break;
        }
    }

}
