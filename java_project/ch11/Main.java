package java_project.ch11;

public class Main {
    public static void main(String[] args) {
       new ClientThread("Alice").start();
       new ClientThread("Bobby").start();
       new ClientThread("Chris").start();
    }
}
