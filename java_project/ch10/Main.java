package java_project.ch10;

public class Main {
    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try{
            // 쓰레드 기동
            CountupThread t = new CountupThread();
            t.start();

            // 조금 시간 대기
            Thread.sleep(10000);

            // 쓰레드 종료 요청
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            System.out.println("main: join");

            // 쓰레드 종료 기다림
            t.join();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: END"); // t종료 로그 후 찍힘
    }
}
