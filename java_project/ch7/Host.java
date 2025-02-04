package java_project.ch7;

public class Host {
    private final Helper helper = new Helper();
    // 익명 내부 클래스 안에서 메소드의 인수나 지역변수를 이용하는 경우 변수를 final 선언해야함
    public void request(final int count, final char c) {
        System.out.println("     request(" + count + ", " + c + ") BEGIN");
        //==========================
        /**
         * Java의 익명 내부 클래스
         * 클래스의 선언, 인스턴스의 생성, 나아가 쓰레드의 기동 한꺼번에 기술
         */
        new Thread() {
            public void run() {
                helper.handle(count, c);
            }
        }.start();
        //==========================
        System.out.println("     request(" + count + ", " + c + ") END");
    }
}
