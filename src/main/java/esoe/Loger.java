package esoe;

import esoe.model.*; //надо добавить модель listCard

import javax.swing.*;
import java.awt.*;

/**
 * log - это таблица, совокупность сообщений о произошедших или грядущих событиях
 * делаю ... ---> сделал ...
 *
 * назначение:
 * 1. мониторинг хода выполнения программ, дла упрощения поиска ошибок.
 *
 * метод использования:
 * 1. к программе прикрепляется объект loger extends ArrScheme
 *
 * 2. когда необходимо записать в лог сообщение,
 * разработчик обращается к соответствующему методу логера,
 * например: loger.type.add(message);
 * или: logger.add(messaege, type);
 *
 * 3. Настройки логера:
 * - куда писать лог? (в файл, в базу, в стрим) по ходу разработки важнее всего видеть стрим.
 * -
 */

public class Loger extends ArrScheme
{
    public String[] header = {"id", "message", "type"};
    public Object[][] data = new Object[1][3];
    public Message mes = new Message();

    //классификация методов испольования логера
    public Loger user; //= new Loger(); //действие пользователя
    public Loger sys; //= new Loger(); //действие программы
    public Loger ex; //= new Loger(); //сообщение об ошибке catch

    //инициирует переменные при запуске логера
    public Loger(){
        /**
        user.mes.setId(1);
        user.mes.setContent("... loger действий пользователя (user) инициирован ...");
        user.mes.setType("user");
        user.add(user.mes);

        sys.mes.setId(1);
        sys.mes.setContent("... loger системных сообщений (sys) инициирован ...");
        sys.mes.setType("sys");
        sys.add(sys.mes);

        ex.mes.setId(1);
        ex.mes.setContent("... loger исключительных ситуаций (ex) инициирован ...");
        ex.mes.setType("user");
        ex.add(ex.mes);
         */
    }

    //в mes пишет новые значения, перещитывает id и указывает type
    public void message(String s){
        mes.setId(mes.getId() + 1);
        mes.setContent(s);
        this.add(mes);
    }

    //добавим сообщение к data
    public Object[][] add(Message m){
        Object[][] d = new Object[this.getRowCount()+1][3];//создаем двумерный массив на одну строку длиннее data
        //если в data нет ни одной строки, и переписывать данные не нужно, заполняем первую строку нового массива
        if (this.getRowCount() == 0){
            d[0][0] = m.getId();
            d[0][1] = m.getContent();
            d[0][2] = m.getType();
        }else{
            //если data не пустой, копируем данные в новый массив
            int i = 0;
            while (i<this.getRowCount()) {
                int j = 0;
                while (j < 3){
                    d[i][j] = this.data[i][j];
                    j++;
                }
                i++;
            }
            //заполняем новую строку данными нового сообщения
            d[this.getRowCount()][0] = m.getId();
            d[this.getRowCount()][1] = m.getContent();
            d[this.getRowCount()][2] = m.getType();
        }
        //возвращаем новый массив
        return d;
    }

    public void initWidget(){
        new Widget();
    }

    public static void main( String[] args )
    {
        new Loger().initWidget();
    }
}
