package java_project.ch2;

import java.util.List;

// 읽기 쓰레드
public class ReaderThread extends Thread {
    private final List<Integer> list;
    public ReaderThread(List<Integer> list) {
        super("ReaderThread"); // TODO? 왜 super?
        this.list=list;
    }

    public void run(){
        while(true) {
            for(int n : list) {
                System.out.println(n);
            }
        }
    }
}
