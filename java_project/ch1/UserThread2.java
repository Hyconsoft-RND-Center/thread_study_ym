package java_project.ch1;

public class UserThread2 extends Thread {
    // 개별 사람을 만들 클래스 -> 인스턴스 생성해서 gate 통과예정
    // 이름, 출신지 필드 가짐
    // gate를 통과하는 메서드 가짐

    // private final Gate gate; // gate 필드 
    private final Gate2 gate; // gate 필드 
    private final String myname; // 이름 필드
    private final String myaddress; // 출신지 필드

    // 생성자
    // **final 키워드** : 생성자로 초기화 된 후 다시 대입되지(변경되지) 않는다.
    public UserThread2(Gate2 gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    // 쓰레드 run 메서드
    public void run() {
        System.out.println(myname+" BEGIN");
        while (true) {
            gate.pass(myname, myaddress);
        }
    }
}
