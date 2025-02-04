package java_project.ch4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// 현재 데이터
public class Data {
    private final String filename; // 저장하는 파일명
    private String content; // 데이터 내용
    private Boolean changed; // 내용 변경 여부 // true:변경있음, false:변경없음 = **flag라고 함
    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    // 데이터의 내용을 수정
    public synchronized void change(String newContent) {
        content= newContent; // 수정인지 아닌지 알 수 있는건 change 뿐이다. 그럼 언제 false로 됨?
        changed= true;
    }

    // 데이터의 내용이 변경되었다면 파일에 저장
    public synchronized void save() throws IOException {
        if(!changed) {
            return; // 기다리는게 아니고 중단
        }
        doSave();
        changed=false; // 책에서 누락된 라인
    }

    // 데이터의 내용을 실제로 파일에 저장
    public void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }    
}
