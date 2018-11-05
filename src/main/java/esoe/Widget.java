package esoe;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
    JFrame tmpFrame;//форма, для вывода логера в отдельном окне
    Container lf;//контекстная панель, для управления цветом формы
    BorderLayout bl = new BorderLayout();
    GridLayout gl = new GridLayout();

    public JPanel panelText = new JPanel();//текстовая область
    public JPanel panelSettings = new JPanel();//панель настроек
    public JTextArea ta = new JTextArea(); // текстовая область
    public JTextField tf = new JTextField("командная строка");
    public JButton buttonSettings = new JButton("настройки");
    public Loger log = new Loger();
    //public ModelListener modellistener = new ModelListener();

    public Widget(){
        this.setLayout(bl);
        this.initPanelSettings();
        this.initPanelText();
        this.setVisible(true);
    }

    //форма, для запуска в самостоятельном окне.
    public void initFrame(){
        //log.user.message("инициирую логер");
        tmpFrame = new JFrame("loger");
        lf = tmpFrame.getContentPane();
        tmpFrame.setSize(300,300);
        tmpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lf.setBackground(Color.white);
        tmpFrame.setLayout(gl);
        tmpFrame.setVisible(true);
        tmpFrame.add(this);
    }

    public void initPanelText(){
        panelText.setBackground(Color.blue);
        panelText.setLayout(gl);
        panelText.add(ta, 0);
        ta.setText(log.getText(log.user));
        //log.user
        log.user.addTableModelListener(new ModelListener(log.user) );

        buttonSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("нажата кнопка buttonSettings");
                log.user.message("нажата кнопка buttonSettings");
                ta.append(log.getMessage(log.user));


                /**
                if(panelText.isVisible()){
                    panelText.setVisible(false);
                    panelSettings.setVisible(true);
                }else{
                    panelText.setVisible(true);
                }
                 */
            }
        });

        this.add(buttonSettings, bl.NORTH);
        this.add(panelText, bl.CENTER);
        this.add(tf, bl.SOUTH);
    }

    public void initPanelSettings(){
        panelSettings.setBackground(Color.red);
        //panelSettings.setLayout(gl);
        this.add(panelSettings, bl.CENTER);

        panelSettings.setVisible(false);

    }

    public static void main( String[] args )
    {
        new Widget().initFrame();
    }

}
