import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class StateOfThePhilosophers {
    public static void main(String[] args) {
        Philosopher vasya = new Philosopher("Вяся", "vasya");
        Thread tr1 = new Thread(vasya);
        tr1.setName("vasya");

        Philosopher ivan = new Philosopher("Иван Иваныч", "ivan");
        Thread tr2 = new Thread(ivan);
        tr2.setName("ivan");

        Philosopher chai = new Philosopher("Чай Ковский", "chai");
        Thread tr3 = new Thread(chai);
        tr3.setName("chai");

        Philosopher lya_Lya = new Philosopher("Не надо Ля-Ля", "lya_Lya");
        Thread tr4 = new Thread(lya_Lya);
        tr4.setName("lya_Lya");

        Philosopher wellYou = new Philosopher("Ну вы блин даете...", "wellYou");
        Thread tr5 = new Thread(wellYou);
        tr5.setName("wellYou");
        Fork fork = new Fork();
        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();
        Fork fork4 = new Fork();

        ArrayList VasyaArray = new ArrayList();
        VasyaArray.add(fork);
        VasyaArray.add(fork4);
        Fork.map.put(vasya, VasyaArray);

        ArrayList ivanArray = new ArrayList();
        ivanArray.add(fork);
        ivanArray.add(fork1);
        Fork.map.put(ivan, ivanArray);

        ArrayList chaiArray = new ArrayList();
        chaiArray.add(fork1);
        chaiArray.add(fork2);
        Fork.map.put(chai, chaiArray);

        ArrayList lya_LyaArray = new ArrayList();
        lya_LyaArray.add(fork2);
        lya_LyaArray.add(fork3);
        Fork.map.put(lya_Lya, lya_LyaArray);

        ArrayList wellYouArray = new ArrayList();
        wellYouArray.add(fork3);
        wellYouArray.add(fork4);
        Fork.map.put(wellYou, wellYouArray);
//        for (Object o : Fork.map.keySet()) {
//            Philosopher philosopher = (Philosopher) o;
//            String str = philosopher.getIndex();
//            ArrayList arrayList = Fork.map.get(philosopher);
//            Fork fork0 = (Fork) arrayList.get(0);
//            Fork fork11=(Fork) arrayList.get(1);
//            System.out.println(str +" "+"get(0)="+ fork0+" "+"get(1)="+fork11 );
//        }

        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();
        tr5.start();

    }
}
