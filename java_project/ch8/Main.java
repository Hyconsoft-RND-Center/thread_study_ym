package java_project.ch8;

public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5); // 5명의 worker를 스레드 풀에 생성
        channel.startWorkers(); // worker들을 실행
        new ClientThread("Alice",channel).start();
        new ClientThread("Bobby",channel).start();
        new ClientThread("Chris",channel).start();
    }
}
