package java_project.ch1;

public class Gate2 {
    // gate의 클래스 -> gate 인스턴스를 만듬
    // 통과하는 인스턴스의 순서, 이름, 출신지를 기록
   
    private int count = 0; // 통과한 사람수 카운트 
    private String name = "Nobody"; // 가장 마지막에 문을 통과한 사람의 이름
    private String address = "Nowhere"; // 가장 마지막에 문을 통과한 사람의 출신지

    // 문을 통과하는 메서드
    public synchronized void pass(String name, String address) {
        this.count++;
        this.name = name;
        this.address = address;  
        check();
    } 

    // 모든 필드를 하나의 완성된 포맷의 문장으로 만들어 리턴
    public synchronized String toString() {
        return "No." + count + ": "+ name + ", " + address;
    }

    // gate의 현재 상태 
    private void check() {
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("********** BROKEN **********" + toString());
        }
    }
}
