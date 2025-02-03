package java_project.ch2;

import java.util.List;

// 읽기 쓰레드
public class ReaderThread2 extends Thread {
    private final List<Integer> list;
    public ReaderThread2(List<Integer> list) {
        super("ReaderThread"); // TODO? 왜 super?
        this.list=list;
    }

    public void run(){
        while(true) {
            synchronized (list) {
                for(int n : list) {
                    System.out.println(n);
                }
            }
        }
    }
}
