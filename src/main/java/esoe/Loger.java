package esoe;

import java.util.ArrayList;

/**
 * log - это таблица, совокупность сообщений о произошедших или грядущих событиях
 * делаю ... ---> сделал ...
 *
 * назначение:
 * 1. мониторинг хода выполнения программ, дла упрощения поиска ошибок.
 * 2. мониторинг действий пользователя.
 *
 * метод использования:
 * 1. к программе прикрепляется объект Loger loger = new Loger();
 * добавляются необходимые виы логов: loger.addModel("название");
 *
 * 2. когда необходимо записать в лог сообщение,
 * разработчик обращается к соответствующему методу логера,
 * например: loger.getModel("название").message(string);
 * или: loger.model(0).add(message);
 * - логер используется widget, соответственно там могут быть и добавлены необходимые модели в логер.
 * - в widget также добавляются и слушатели ModelListener событий на каждую модель логера.
 *   (на кажды тип графических элементов, отображающих логи должен быть свой Класс слушателя)
 * - также виды моделей логера могут быть добавлены в самом классе Loger,
 *   при инициализации логера, public Loger(){}
 *
 * 3. Настройки логера:
 * - куда писать лог? (в файл, в базу, в стрим) по ходу разработки важнее всего видеть стрим.
 * -
 */

public class Loger
{
    public Message message;
    public ArrayList<ModelLoger> model = new ArrayList<ModelLoger>();

    //инициирует переменные при запуске логера
    public Loger(){
        addModel("DEFAULT");//добавили модель в список
    }

    //добавляем в модель новое сообщение
    public static void add(ModelLoger m, String s){
        m.message.setId(m.message.getId()+1);//увеличили значение id++
        m.message.setContent(s);//установили контент
                                //type, назваание модели уже задано
        //проверяем существуют ли данные в модели
        if (m.data == null) {
            //задаем начальные параметры data
            m.data = new Object[1][3];
            m.data[0][0] = m.message.getId();
            m.data[0][1] = m.message.getType();
            m.data[0][2] = m.message.getContent();
        }else {
            //создаем новый объект, на строку больше чем data
            Object[][] d = new Object[m.data.length+1][m.header.length];;
            //переписываем в новый объект данные data
            int i = 0;
            while (i < m.data.length){
                int j = 0;
                while (j < m.header.length){
                    d[i][j] = m.data[i][j];
                    j++;
                }
                i++;
            }
            //в последнюю строку нового объекта вносим строку сообщения
            d[m.data.length][0] = m.message.getId();
            d[m.data.length][1] = m.message.getType();
            d[m.data.length][2] = m.message.getContent();
            //переписываем данные из временного объекта в data
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
    }

    public void addModel (String name){
        model.add(new ModelLoger(name));
    }

    //возвращает модель по типу лога
    public ModelLoger getModel(String name){
        ModelLoger m = new ModelLoger();
        boolean bol = false;
        int i = 0;
        //System.out.println("поиск модели ... " + name);
        while (i < this.model.size()){
            if (this.model.get(i).message.getType() == name){
                m = this.model.get(i).getModel();
                bol = true;
            }else {
                //System.out.println("соответствий не найдено, доступна модель ... "
                //       + this.model.get(i).message.getType());
            }
            i++;
        }
        if (bol == false) {
            //System.out.println("совпадений не обнаружено ...");
        }else {
            //System.out.println("... модель" + name + " подключена ...");
        }
        return m;
    }
    public static String getMessage(ModelLoger m){
        return m.getMessage();
    }

    //возвращает данные из модели в виде строки
    public String getText(ModelLoger m){
        String s = "";
        int i = 0;
        while (i < m.getColumnCount()){
            s = s + m.header[i] + " ";
            i++;
        }
        s = s + "\n";

        //добавим условие на случай, если модель данных пустая или отсутствует
        if (m.data != null){
            i = 0;
            if (i < m.getRowCount()){
                while (i < m.getRowCount()){
                    int j = 0;
                    while (j < m.header.length){
                        s = s + m.data[i][j] + " ";
                        j++;
                    }
                    s = s + "\n";
                    i++;
                }
            }
        }else {
            s = s + "в логе " + m.message.getType() + " отсутствуют данные для отображения ..." + "\n";
        }


        return s;
    }
    public void initWidget(){
        new WidgetLoger().initFrame();
    }
    public static void main( String[] args )
    {
        new Loger().initWidget();
    }
}
