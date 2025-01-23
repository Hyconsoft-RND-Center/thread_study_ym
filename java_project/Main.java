package java_project;

public class Main {
    public static void main(String[] args) {
        // 싱글 스레드 실습
        // for(int i = 0;i<1000; i++) {
        //     System.out.print("Good! ");

        // }

        // 멀티 스레드 실습
        System.out.println("======Main class start======");
        
        MyThread t = new MyThread(); // 1. 새로운 MyThread 인스턴스 생성
        t.start(); // 2. Thread 클래스의 start 메서드 실행 = 새로운 쓰레드가 기동

        for(int i = 0;i<1000; i++) {
            System.out.print("Good! "); // Q1. Good -> Nice 출력 | Good, Nice 섞여서 출력되는 이유 => 병행 처리의 순차적 실행 때문
        }

        System.out.println("======Main class end======");
    }
    
}