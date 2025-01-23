package java_project;

public class PracticeMethods {
    /** TODO
     * 실습 예시
     * public void practice1() {
     *  // 코드
     * }
     */
    public void nothing() {
    }

    // 싱글 스레드 실습
    public void singleThreadP() {
        for(int i = 0;i<1000; i++) {
            System.out.print("Good! ");
        }
    }

    // 멀티 스레드 실습
    public void multiThreadsP() {
        // System.out.println("======Main class start======");
        
        MyThread t = new MyThread(); // 1. 새로운 MyThread 인스턴스 생성
        t.start(); // 2. Thread 클래스의 start 메서드 실행 = 새로운 쓰레드가 기동

        for(int i = 0;i<1000; i++) {
            System.out.print("Good! "); // Q1. Good -> Nice 출력 | Good, Nice 섞여서 출력되는 이유 => 병행 처리의 순차적 실행 때문
        }

        // System.out.println("======Main class end======");
    }

    // 쓰레드 기동법 1 실습 : Thread 클래스의 서브 클래스 만들어서, 또 그 인스턴스를 만들어 start로 쓰레드 기동시키는 방법
    public void runThreadP1() {
        new PrintThread("Good!").start();
        new PrintThread("Nice!").start();  // 주의) 인스턴스 생성과 그 인스턴스에 대응하는 쓰레드 기동은 별개의 처리이다.
        // PrintThread 클래스의 인스턴스를 만들고, 그 인스턴스의 start()를 호출함
        // **참고** Thread 클래스도 Runnable 인터페이스를 구현하고 있고, run 메소드를 가진다. 다만, run은 비어있고, 보통은 서브 클래스에 의해 오버라이드 됨
    }

    // 쓰레드 기동법2 실습 : Runnable 인터페이스를 사용
    public void runThreadP2() {
        new Thread(new Printer("Good! ")).start();
        new Thread(new Printer("Nice! ")).start();
        // Printer 클래스의 인스턴스를 생성한 후, 그것을 인수로 제공하여 Thread 클래스의 인스턴스로 만들고, Thread인스턴스의 start()를 호출함

    }

    // 쓰레드의 일시 정지 실습  
    public void threadPauseP() {
        for(int i = 0;i<10000;i++) {
            System.out.print("Good! "); // 1000ms(1초)마다 출력
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                // sleep 메소드의 호출은 InterruptedException 예외를 종종 통보하기 때문에 try-catch 사용 필요
            }
        }
    }

    // 쓰레드의 베타제어 실습 : 멀티 쓰레드 프로그램에서 복수의 쓰레드가 같은 인스턴스를 동시에 조작할 때 발생하는 문제
    // 복수의 쓰레드가 경쟁함 = data race 혹은 race condition이라고 함
    // 이 data race를 방지하기 위해서 교통정리를 함 => 이것이 베타 제어, 상호 베타(mutual exclusion)
    public void mutualExclusionP(String name, int money) {
        // synchronized 키워드 사용 -> 이 키워드가 붙은 메서드는 하나의 쓰레드로 동작함 => 한번에 한개의 쓰레드만 실행시킬 수 있음 => 동기 메소드라고도 함
        // synchronized 메서드는 한번에 한개의 쓰레드 밖에 실행할 수 없다
        // synchronized 가 아닌 메서드는 동시에 2개 이상의 쓰레드에서도 실행할 수 있다

        // wait, notify, notifyAll

        
        // synchronized 메서드 ?
        // synchronized 블록 ?
        Bank bank = new Bank(name, money); // TODO 스레드를 각자 실행해서 Bank 메서드를 호출하게
    }
}
