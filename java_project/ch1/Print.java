package java_project.ch1;

public class Print {
    private String s; // 공유 자원

    // 테스트용 synchronized 함수
    public synchronized void testFunc() {
        System.out.println("10초 sleep 시작");
        try{
            Thread.sleep(10000);
            System.out.println("10초 sleep 종료");
        } catch(InterruptedException e) {
        }
    }

    // 값 설정과 검증
    public synchronized void setAndTest(String s, String expectedValue) {
        this.s = s; // 값 설정
        System.out.println(Thread.currentThread().getName() + " output thread value: " + this.s);

        // 검증
        if (!this.s.equals(expectedValue)) {
            System.out.println("***********ERROR********** " + Thread.currentThread().getName() +
                               " expected " + expectedValue + " but got " + this.s);
        }
    }
}
