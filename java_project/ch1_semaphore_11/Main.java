import java.util.Random;
import java.util.concurrent.Semaphore;

class Log {
    public static void println(String s) {
        System.out.println((Thread.currentThread().getName())+": "+s);
    }
}

class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);

    // 클래스 생성자
    public BoundedResource(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    // 리소스 사용
    public void use() throws InterruptedException {
        semaphore.acquire();
        try{
            doUse();
        } finally {
            semaphore.release();
        }
    }

    // 리소스를 실제로 사용한다.
    protected void doUse() throws InterruptedException {
        Log.println("BEGIN: used = "+(permits-semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END:  used="+(permits-semaphore.availablePermits()) );
    }
}

class UserThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;

    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try{
            while (true) {
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch(InterruptedException e) {
            
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 3개의 리소스 준비
        BoundedResource resource = new BoundedResource(3);

        // 10개의 쓰레드가 사용한다
        for(int i=0;i<10;i++) {
            new UserThread(resource).start();
        }
    }
}