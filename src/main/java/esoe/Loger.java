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

public class Loger
{
    public int id;
    public String type;
    public String mes;

    //классификация методов испольования логера
    public Model merj;
    public Model user; //действие пользователя
    public Model sys; //действие программы
    public Model ex; //сообщение об ошибке catch

    //инициирует переменные при запуске логера
    //при необходимости добавить новый тип лога, править именно тут
    public Loger(){


        //инициируем лог user
        id = 1;
        type = "user";
        mes = "... loger действий пользователя (user) инициирован ...";
        user = new Model(id, type, mes);

        //инициируем логер системных сообщений
        id = 1;
        type = "sys";
        mes = "... loger системных сообщений (sys) инициирован ...";
        sys = new Model(id, type, mes);

        //инициируем логер исключительных ситуаций
        id = 1;
        type = "ex";
        mes = "... loger исключительных ситуаций (ex) инициирован ...";
        ex = new Model(id, type, mes);

    }


    public static String getMessage(Model m){
        String s = "";
        s = s + m.id + " " + m.type + " " + m.mes + "\n";
        return s;
    }

    /**
     *
     * @param m
     * @param s
     */
    public static void add(Model m, String s){
        m.id++;
        m.mes = s;

        Object[][] d = new Object[m.data.length+1][m.header.length];;
        int i = 0;
        while (i < m.data.length){
            int j = 0;
            while (j < m.header.length){
                d[i][j] = m.data[i][j];
                j++;
            }
            i++;
        }
        d[m.data.length][0] = m.id;
        d[m.data.length][1] = m.type;
        d[m.data.length][2] = m.mes;
        //System.out.println(m.type);


        m.data = new Object[d.length][m.header.length];
        i = 0;
        while (i < m.data.length){
            int j = 0;
            while (j < m.header.length){
                m.data[i][j] = d[i][j];
                j++;
            }
            i++;
        }
    }

    public String getText(Model m){
        String s = "";
        int i = 0;
        while (i < m.header.length){
            s = s + m.header[i] + " ";
            i++;
        }
        s = s + "\n";

        i = 0;
        while (i < m.data.length){
            int j = 0;
            while (j < m.header.length){
                s = s + m.data[i][j] + " ";
                j++;
            }
            s = s + "\n";
            i++;
        }

        return s;
    }

    public void initWidget(){
        new Widget();
    }

    public static void main( String[] args )
    {
        new Loger().initWidget();
    }
}
