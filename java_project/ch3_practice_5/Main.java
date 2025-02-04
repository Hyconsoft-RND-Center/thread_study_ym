package java_project.ch3_practice_5;

import java_project.ch3.Request;
import java_project.ch3.RequestQueue;

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue1 = new RequestQueue(); 
        RequestQueue requestQueue2 = new RequestQueue();

        /** 
         * 연습문제 3-5 
         * Q: 왜 시작만하고 프로그램이 멈출까?
         * A: 두 큐가 비어있는 상태에서 TalkThread쓰레드를 실행하면 getRequest를 통해 둘다 나란히 wait셋에 들어가게 되어 생존성을 잃음
         * 
         * TODO 그럼 어떻게 하면 서로 핑퐁하며 느낌표가 늘어나는 프로그램을 만들 수 있나?
         * 현재 TalkThread는 무조건 큐에서 대화를 하나 꺼내고 거기다가 느낌표를 붙이고 있다(서로 먼저 넣지는 않고 꺼내기만 함)
         * -> 두 큐 중 하나에만 먼저 값을 넣는다.
         * -> getRequest() 호출시 무조건 wait 메서드가 호출되므로(아무것도 없어서) 큐에 데이터가 있는지 없는지 알 수 없으므로 다른 방법은 없다.
         */
        // requestQueue1.putRequest(new Request("안녕!"));
        requestQueue2.putRequest(new Request("안녕!"));

        new TalkThread(requestQueue1, requestQueue2, "Alice").start();
        new TalkThread(requestQueue2, requestQueue1, "Bobby").start();
    }
}

