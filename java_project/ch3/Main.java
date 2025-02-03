package java_project.ch3;

public class Main {
    /**
     * Guarded Suspension Pattern = guarded wait = busy wait = spin lock = polling 등등 비슷한 패턴으로 처리하는 여러가지 방법들이 있음
     * 어떠한 조건문을 통해 조건에 맞을 경우에만 실행시키고, 충족하지 않을 경우 쓰레드를 대기시키(wait())는 패턴
     * 
     * 실행할 수 있는 조건 = 충족시켜야 할 조건 = Guarded Suspension Pattern의 가드 조건
     * 
     * 조건부 synchronized => single threaded execution pattern은 쓰레드가 크리티컬 섹션 코드를 실행하면 lock 취득하여 그 외 쓰레드가 대기함
     * Guarded Suspension Pattern에서는 쓰레드 대기 여부가 조건에 의해 결정되므로 조건부 synchronized 라고 할 수 있음
     * 
     * wait 중인 쓰레드는 notify/notifyAll 될 때마다 가드 조건을 테스트함 = guarded object의 상태가 변경되지 않는다면 영원히 진척될 수 없음 = 생존성 없음
     * 
     * wait 과 notify/notifyAll은 guarded suspension Pattern이 구현되어있는 클래스 안에서만 사용되게 하여 재사용 가능하게!
     * 
     * 조건부로 쓰레드를 대기하게 하는 이런 패턴은 특징이 있음
     * 1. 루프(반복) 이 있다.
     * 2. 조건부가 있다.
     * 3. 기다린다.
     */
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();

        new ClientThread(requestQueue, "Alice", 3141592L).start();
        new ServerThread(requestQueue, "Bobby", 6535897L).start();
    }
}
 