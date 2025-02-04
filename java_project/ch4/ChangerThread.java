package java_project.ch4;

import java.io.IOException;
import java.util.Random;

// 데이터의 내용을 변경한 후 저장
public class ChangerThread extends Thread {
    private final Data data;
    private final Random random=new Random();
    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            for(int i=0;true;i++) {
                data.change("No. " +i); // 데이터 변경
                Thread.sleep(random.nextInt(1000)); // 작업
                data.save(); // 명시적 저장
            }
        }catch(IOException e) {
            e.printStackTrace();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
