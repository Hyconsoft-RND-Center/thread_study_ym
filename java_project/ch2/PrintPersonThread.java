package java_project.ch2;

public class PrintPersonThread extends Thread {
    private Person person;
    public PrintPersonThread(Person person) {
        this.person= person;
    }

    public void run() {
        while (true) {
            // *** 문자열과 인스턴스가 + 로 연결되면 자동적으로 인스턴스를 나타내는 식인 toString 메서드가 호출됨(Java 규칙) ***
            System.out.println(Thread.currentThread().getName() + "prints" + person);
        }
    }
}
