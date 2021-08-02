import java.util.ArrayList;

/**
 * @author Мосолов
 */
/**Создание класса филосов. Наследуется класс спагетти, где устанавливается количество их.
Так же имплементируется интерфейс Runnable для создания потоков*/
public class Philosopher extends PlateOfSpaghetti implements Runnable {
    /**
    // Поля имя и индекс, по которому будет сравниваться какой поток и ключ в мапе*/
    private String name;
    private String index;
/**
 * Конструктор-создание нового объекта*/

    public Philosopher(String name, String index) {
        this.index = index;
        this.name = name;
    }
    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
    /**
/* метод интерфейса Runnable, создающий поток. В нем проверяется количество спагетти в тарелке и
    метод conditionPhilosopher() из Fork(вилка). В том методе проверяется, может ли филосов взять
    2 вилки сразу. Если true, то начинает есть, потом устанавливает свои вилки в состояние true
            (положил вилки на стол).Если false , то пропускается и выдается сообщение о том что он
    думает.*/
    @Override
    public void run() {
        String nameProcess = Thread.currentThread().getName();
        Thread tr = Thread.currentThread();
        while (theAmountOfSpaghetti > 0) {
            if (Fork.conditionPhilosopher()) {
                System.out.println("Философ " + nameProcess + " ем спагетти");
                theAmountOfSpaghetti-=5;
                for (Object ph : Fork.map.keySet()) {
                    Philosopher philosopher = (Philosopher) ph;
                    String str = philosopher.getIndex();
                    if (nameProcess.equals(str)) {
                        ArrayList arrayList = Fork.map.get(philosopher);
                        Fork fork0 = (Fork) arrayList.get(0);
                        Fork fork1 = (Fork) arrayList.get(1);
                        fork0.setCondition(true);
                        fork1.setCondition(true);

                    }
                }
            } else {
                System.out.println("Филосов " + getName() + " думает о чем то");
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Дошик закончился у "+nameProcess);
    }
}

/*   цикл для тестов  состояния вилок
                for (Object o : Fork.map.keySet()) {
                        Philosopher philosopherTemp = (Philosopher) o;
                        String strTemp = philosopher.getIndex();
                        ArrayList arrayListTemp = Fork.map.get(philosopherTemp);
                        Fork fork0Temp = (Fork) arrayListTemp.get(0);
                        Fork fork11 = (Fork) arrayList.get(1);
                        System.out.println(strTemp + " " + "get(0)=" + fork0Temp + " " + "get(1)=" + fork11);
                    }
*/
