package java_project.ch5;

// Channel
public class Table {
    private final String[] buffer; // TODO String 배열을 담은 변수 생성
    private int tail; //다음에 put할 장소
    private int head; //다음에 take할 장소
    private int count; //buffer안의 케이스 수
    public Table(int count) {
        this.buffer = new String[count]; // count 만큼의 길이를 가진 String데이터를 저장할 수 있는 배열 생성
        this.head=0;
        this.tail=0;
        this.count=0;
    }

    // 케이크를 놓음 // push
    // throws InterruptedException 의미 = 이 메소드는 취소가 가능하다
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        // guarded suspension pattern
        while (count >= buffer.length) {
            wait();    
        }
        buffer[tail] = cake;
        tail=(tail+1) % buffer.length; // 0,1,2,0,1,2, .... 반복
        count++;
        notifyAll();
    }

    // 케이크를 먹음 // pop
    public synchronized String take() throws InterruptedException {
        // guarded suspension pattern
        while (count <= 0) {
            wait();
        }

        String cake = buffer[head];
        head=(head+1) % buffer.length; // 0,1,2,0,1,2, .... 반복
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
