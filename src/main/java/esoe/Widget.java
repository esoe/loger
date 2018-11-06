package esoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * графический интерфес, для loger:
 * 1. форма
 * 2. панелька widget
 * 3. скролпенел
 * 4. текстовая область
 * 5. кнопка настроек, панелька настроек, отображается вместо текстовой области
 * 6. текстовое поле
 */

public class Widget extends JPanel {
    public JFrame tmpFrame;//форма, для вывода логера в отдельном окне
    Container lf;//контекстная панель, для управления цветом формы
    BorderLayout bl = new BorderLayout();
    GridLayout gl = new GridLayout();

    public JPanel panelText = new JPanel();//текстовая область
    public JComboBox combo;
    public JTextArea ta = new JTextArea(); // текстовая область
    public JScrollPane panelScroll = new JScrollPane (ta);
    public Loger log; //модель DEFAULT сформирована
    public ModelListener modelDEFAULTlistener; //слушатель модели DEFAULT
    public ModelListener modelUSERlistener; //слушатель модели USER

    public Widget(){
        this.initLoger();//лучше инициировать первым, чтобы не пришлось отображать еще не созданные данные
        this.setLayout(bl);
        this.initPanelText();
        this.initCombo();
        this.setVisible(true);
    }

    public void initLoger(){
        log = new Loger();//модель DEFAULT сформирована
        modelDEFAULTlistener = new ModelListener(log.getModel("DEFAULT"), ta);//слушатель DEFAULT
        log.getModel("DEFAULT").addTableModelListener(modelDEFAULTlistener);
        log.addModel("USER");//модель USER добавлена в loger
        modelUSERlistener = new ModelListener(log.getModel("USER"), ta);//слушатель USER
        log.getModel("USER").addTableModelListener(modelUSERlistener);
    }

    //форма, для запуска в самостоятельном окне.
    public void initFrame(){
        tmpFrame = new JFrame("loger");
        lf = tmpFrame.getContentPane();
        tmpFrame.setSize(450,300);
        tmpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lf.setBackground(Color.white);
        tmpFrame.setLayout(gl);
        tmpFrame.setVisible(true);
        tmpFrame.add(this);
    }

    public void initPanelText(){
        panelText.setBackground(Color.blue);
        panelText.setLayout(gl);
        panelText.add(panelScroll, 0);
        this.add(panelText, bl.CENTER);
    }

    public void initCombo(){
        String[] models = new String[log.model.size()];
        int i = 0;
        while (i<log.model.size()){
            models[i] = log.model.get(i).message.getType();
            i++;
        }
        combo = new JComboBox(models);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                String modelChoice = (String)box.getSelectedItem();
                String s = "Не играйся с combo, пока бесполезно ... \n";
                //s = s + log.getText(log.getModel(modelChoice));//надо править getText, добавить условие при отсутствии данных
                ta.setText(s); //вывести все записи в одной модели
                log.getModel("USER").message("... выбрана модель ..." + modelChoice + " ...");
                tmpFrame.setTitle("loger: "+ modelChoice);

            }
        };
        combo.addActionListener(actionListener);
        combo.setEditable(false);
        this.add(combo, bl.NORTH);
    }
    public static void main( String[] args )
    {
        new Widget().initFrame();
    }

}
