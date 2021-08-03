import java.util.ArrayList;
import java.util.HashMap;

public class Fork {
    private boolean condition = true;
    public static HashMap<Object, ArrayList> map = new HashMap<>();

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    //    вилка Шредингера
    public static synchronized boolean conditionPhilosopher() {
        String nameProcess = Thread.currentThread().getName();
        for (Object ph : map.keySet()) {
            Philosopher philosopher = (Philosopher) ph;
            String str = philosopher.getIndex();
            if (nameProcess.equals(str)) {
                ArrayList arrayList = map.get(philosopher);
                Fork fork0 = (Fork) arrayList.get(0);
                boolean forkLeft = fork0.isCondition();
                Fork fork1 = (Fork) arrayList.get(1);
                boolean forkRight = fork1.isCondition();
                if (forkLeft && forkRight) {
                    fork0.setCondition(false);
                    fork1.setCondition(false);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Fork{" +
                "condition=" + condition +
                '}';
    }
}
