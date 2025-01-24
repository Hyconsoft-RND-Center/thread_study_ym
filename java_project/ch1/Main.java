package java_project.ch1;

public class Main {
     public static void main(String[] args) {
        /**
         * Single Threaded Execution Pattern
         * 한번에 한사람이 건너는 gate
         * gate를 통과하려는 3개의 인스턴스
         * 통과시 카운트 및 기록 예정
         */
        System.out.println("============ Testing Gate, hit CRTL+C to exit ============");

        // gate 생성
        // Gate gate = new Gate();
        Gate2 gate2 = new Gate2();

        // 3개의 인스턴스를 생성함
        // 3개의 인스턴스는 쓰레드들이고, 각자 다른 쓰레드를 기동시킴
        // 각 인스턴스를 gate로 통과시킴
        // new UserThread(gate2, "Alice", "Alaska").start();
        // new UserThread(gate2, "Bobby", "Brazil").start();
        // new UserThread(gate2, "Chris", "Canada").start();
        new UserThread2(gate2, "Alice", "Alaska").start();
        new UserThread2(gate2, "Bobby", "Brazil").start();
        new UserThread2(gate2, "Chris", "Canada").start();
    }
}
