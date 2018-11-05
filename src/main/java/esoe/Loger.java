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

    public void initWidget(){
        new Widget();
    }

    public static void main( String[] args )
    {
        new Loger().initWidget();
    }
}
