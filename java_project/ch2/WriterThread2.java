package java_project.ch2;

import java.util.List;

// 쓰기 클래스
public class WriterThread2 extends Thread {
    private final List<Integer> list;
    public WriterThread2(List<Integer> list) {
        super("WriterThread");
        this.list=list;
    }

    public void run() {
        for(int i=0; true;i++){
            list.add(i);
            list.remove(0);
        }
    }
}
