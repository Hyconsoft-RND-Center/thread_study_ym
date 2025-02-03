package java_project.ch1_practice_7;
// TODO 1-7
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    // TODO 챕터 3 완료한 후 아래 코드가 정상 동작하도록 Mutex 클래스 생성해보기
    private final Mutex mutex = new Mutex()

    public void pass(String name, String address) {
        // synchronized
        mutex.lock()
        try{
            this.counter++;
            this.name=name;
            this.address=address;
            check();
        } catch(InterruptedException e) {}
    }

    public String toString() {
        // synchronized 아님
        String s = null;
        mutex.lock();
        try{
            s = "No. " + counter + ": " + name + ", " + address;
        } finally {
            mutex.unlock();
        }
        return s;
    }

    private void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("****** BROKEN ****** "+toString());
        }
    }
}
