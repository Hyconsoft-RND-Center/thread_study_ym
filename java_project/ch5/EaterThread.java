package java_project.ch5;

import java.util.Random;

// Consumer
public class EaterThread extends Thread {
    private final Random random;
    private final Table table;

    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.table= table;
        this.random = new Random(seed);
    }

    public void run() {
        try{
            while (true) {
                String cake = table.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch(InterruptedException e) {}
    }
}
