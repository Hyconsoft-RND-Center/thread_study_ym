package java_project.ch1_practice_5;

import java.util.Random;

class TestThread extends Thread {
    private SecurityGate gate;
    private static Random random = new Random();
    public TestThread(SecurityGate gate) {
        this.gate = gate;
    }
    private void waitRandomTime() {
        int sleepTime = 1000 + random.nextInt(10000);
        try{
            Thread.sleep(sleepTime);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("THREAD INTERRUPT !!");
        }
    }
    
    public void run() {
        System.out.println("THREAD START !!");

        while (true) {
            /**
             * 무한 반복 루프 메서드 생성
             * 1. getCounter로 현재 입장인원 가져옴 + 출력
             * 2. 현재 입장인원이 5미만이면 입장 아니면 랜덤시간 대기 후 다시 1부터 시도
             * 3. 입장한 후 랜덤 시간 후 퇴장
             */
            int currentCounter = gate.getCounter();
            System.out.println("CURRENT COUNTER : "+ currentCounter);
            
            if (currentCounter < 5) {
                gate.enter();
                waitRandomTime();
                gate.exit();
            } else {
                System.out.println("GATE IS FULL");
                waitRandomTime();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. SecurityGate 인스턴스 생성
        SecurityGate gate = new SecurityGate();
    
        // 2. 쓰레드를 10개 생성하여 실행
        new TestThread(gate).start();
        new TestThread(gate).start();
        new TestThread(gate).start();
        new TestThread(gate).start();
        new TestThread(gate).start();
        new TestThread(gate).start();
        new TestThread(gate).start();
        new TestThread(gate).start();
        new TestThread(gate).start();
        new TestThread(gate).start();
    }
}
