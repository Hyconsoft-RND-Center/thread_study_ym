package java_project.introduction;

public class Bank {
    private int money; // 동시에 읽고 쓰면 안되는 필드
    private String name; // 상관없는 필드

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // synchronized 메서드는 해당 인스턴스의 락을 취하고 있는 쓰레드만(하나의 쓰레드만)이 실행할 수 있다.
    // 락을 가지지 못한 쓰레드가 wait, notify, notifyAll 메소드를 호출하면 예외 java.lang.IlegalMonitorStateException 발생
    // notify가 성능상으로는 빠르지만 깨워지는 쓰레드를 알 수 없기 때문에 notifyAll 을 사용하는 것이 일반적이고 견고한 코드가 됨0
    // 예금
    public synchronized void deposit(int m) {
        money += m;
    }

    // 인출
    public synchronized boolean withdraw(int m) {
        if(money >= m) {
            money -= m;
            return true; // 인출 가능
        } else {
            return false; // 인출 불가능
        }
    }

    public String getName() {
        // name은 여러 곳에서 가져다 써도 상관없기 때문에 synchronized 필요없음
        return name;
    }
}

