package java_project.ch4;

// 조건을 만족하지 않으면 일정시간 기다리고, 기다린 후에도 만족하지 않으면 중단한다
// 타임아웃 구현 실습
// guarded timed 구현 예제
public class Host {
    private final long timeout; // 타임아웃값
    private boolean ready=false; // 메소드를 실행해도 되면 true

    public Host(long timeout) {
        this.timeout = timeout;
    }

    //상태를 변경한다
    public synchronized void setExecution(boolean on) {
        
    }
}
