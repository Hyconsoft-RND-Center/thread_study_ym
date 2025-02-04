package java_project.ch10;

public class CountupThread extends Thread {
    // 카운터의 값
    private long counter = 0;

    // 종료 요구가 들어오면 true
    // TODO volatile ? 
    private volatile boolean shutdownRequested = false;

    // 종료 요구 메서드
    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    // 종료 요구가 들어왔는지 테스트
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // 동작
    public final void run() {
        try{
            while(!isShutdownRequested()) {
                doWork();
            }
        } catch(InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    // 작업
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = "+ counter);
        Thread.sleep(500);
    }
    
    // 종료 처리
    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
