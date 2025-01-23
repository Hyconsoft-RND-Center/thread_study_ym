package java_project;

public class Bank {
    private int money; // 동시에 읽고 쓰면 안되는 필드
    private String name; // 상관없는 필드

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

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

