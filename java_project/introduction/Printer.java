package java_project.introduction;

public class Printer implements Runnable{
    private String message;

    public Printer(String message) {
        this.message = message;
    }

    /**
     * public interface Runnable {
     *      public abstract void run();
     * }
     */
    public void run() {
        // Runnable 인터페이스를 구현한 클래스는 반드시 run 메소드를 구현해야 함
        for(int i=0;i<10000;i++) {
            System.out.print(message);
        }
    }
}
