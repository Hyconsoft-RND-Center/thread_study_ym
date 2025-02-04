package java_project.ch3_practice_5;

import java_project.ch3.Request;
import java_project.ch3.RequestQueue;

public class TalkThread extends Thread {
    private final RequestQueue input; 
    private final RequestQueue output;
    public TalkThread (RequestQueue input, RequestQueue output, String name) {
        super(name); // 상속받은 부모의 생성자를 호출하는 메서드 -> name을 주면 Thread의 name 필드에 저장되는 듯
        this.input = input;
        this.output = output;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " : BEGIN");
        for(int i=0;i<10;i++){
            // 상대로부터 리퀘스트를 받는다
            Request request1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + request1);
            
            // 느낌표를 하나 붙여서 상대방에게 돌려준다.
            Request request2 = new Request(request1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + request2);
            output.putRequest(request2);
        }
        System.out.println(Thread.currentThread().getName() + " : END");
    }
}
