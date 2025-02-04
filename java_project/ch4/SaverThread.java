package java_project.ch4;

import java.io.IOException;

// 데이터 내용을 정기적으로 저장
public class SaverThread extends Thread {
    private final Data data;
    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try{
            while(true) {
                data.save();
                Thread.sleep(10000);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
