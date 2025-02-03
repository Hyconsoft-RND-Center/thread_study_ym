package java_project.ch1_practice_5;

public class SecurityGate {
    private int counter;
    
    public synchronized void enter() {
        counter++;
    }
    public synchronized void exit() {
        counter--;
    }
    
    public synchronized int getCounter() {
        return counter;
    }
}
