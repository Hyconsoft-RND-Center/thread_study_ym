package java_project.ch2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main4 {
    public static void main(String[] args) {
        final List<Integer> list = new CopyOnWriteArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
