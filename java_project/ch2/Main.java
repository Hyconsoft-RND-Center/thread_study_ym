package java_project.ch2;

public class Main {
     public static void main(String[] args) {
        /**
         * Immutable Pattern
         * 인스턴스의 상태를 절대로 바꾸지 않도록 클래스를 설계하는 것
         * 
         * 왜? 
         * 인스턴스의 상태가 절대 바뀌지 않는다면 멀티 쓰레드의 배타 제어가 필요 없기 때문
         * = synchronized로 가드할 필요가 없다.
         */

        // 기본 사용 예 (Person이 immutable한 클래스이다.)
        Person alice = new Person("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();

        // **필드가 보유하고 있는 인스턴스를 그대로 getter 메소드의 반환 값으로 사용할 때 오류 발생 케이스
        // TODO ch2_practice_4
        // **생성자에게 인수로서 건낸 인스턴스를 그대로 필드에 대입할 때 오류 발생 케이스
        // TODO 2-5
        
    }
}
