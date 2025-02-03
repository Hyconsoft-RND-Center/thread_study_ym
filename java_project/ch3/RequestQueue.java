package java_project.ch3;

import java.util.LinkedList;
import java.util.Queue;

// **guarded object
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    // **guarded method
    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            // 사전 조건
            try{
                // **wait() 자체도 실행하려면 쓰레드가 해당 인스턴스의 락을 취하고 있어야함 = wait()의 위치 확인 완료
                System.out.println("큐가 비어있음 (무조건 false) " + (queue.peek() != null));
                wait(); // 쓰레드가 왜 기다리고 있는지 이유를 알아야 -> 어디에서 깨울지 알 수 있음
                // 인스턴스 상태가 바뀌어서 가드 조건(queue.peek()!= null)이 충족되기를 기다리고 있음
            } catch(InterruptedException e) {}
        }
        return queue.remove(); // 목적하는 처리
    }

    // **state changing method
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        System.out.println("큐가 있어서 깨움 (무조건 true)" + (queue.peek() != null));
        notifyAll(); // 가드 조건을 충족하므로 wait set의 쓰레드들을 깨움
    }
}
