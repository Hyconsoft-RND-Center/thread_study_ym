package java_project.ch1_practice_6.deadlockSolved2;

import java_project.ch1_practice_6.Tool;

public class EaterThread extends Thread {
    private String name;
    private final Tool lefthand;
    private final Tool righthand;
    public EaterThread(String name, Tool lefthand, Tool righthand) {
        this.name = name;
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    public void run() {
        while (true) {
            // TODO
            synchronized (this) {
                eat();
            }
        }
    }
    
    // public synchronized void eat() {
    // TODO
    public void eat() {
        // synchronized (lefthand) {
            System.out.println(name + " takes up " + lefthand + " (left).");
            // synchronized (righthand) {
                System.out.println(name + " takes up " + righthand + " (right).");
                System.out.println(name + " is eating now, yum yum!");
                System.out.println(name + " puts down " + righthand + " (right).");
            // }
            System.out.println(name + " puts down " + lefthand + " (left).");
        // }
    }
}
