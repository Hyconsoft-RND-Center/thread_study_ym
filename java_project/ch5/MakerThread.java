package java_project.ch5;

import java.util.Random;

// Producer
public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    public static int id= 0; //케이트 안내번호 (요리사 전원 공통) 

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table =table;
        this.random= new Random(seed);
    }

    public void run() {
        try{
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
                table.put(cake);
            }
        } catch(InterruptedException e) {}
    }
    
    private static synchronized int nextId() {
        return id++;
    }    
}
