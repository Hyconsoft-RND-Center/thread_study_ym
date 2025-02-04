package java_project.ch3_practice_6;

import java_project.ch3.ClientThread;
import java_project.ch3.RequestQueue;

// 연습문제 3-6 p173
// TODO chapter5 끝내고 풀기
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue(); 
        Thread alice = new ClientThread(requestQueue, "Alice", 314159L);
        Thread bobby = new ClientThread(requestQueue, "Bobby", 265358L);

        alice.start();
        bobby.start();

        try{
            Thread.sleep(10000);
        } catch(InterruptedException e) {}

        System.out.println("***** calling interrupt *****");
        alice.interrupt();
        bobby.interrupt();
    }
}

