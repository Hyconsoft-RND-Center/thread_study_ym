package java_project.ch2_practice_3;

public class Main {
    private static final long CALL_COUNT = 1000000000L;
    public static void main(String[] args) {
        trial("Synch", CALL_COUNT, new Synch());
        trial("NotSynch", CALL_COUNT, new NotSynch());
    }

    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + ": BEGIN");
        long start_time = System.currentTimeMillis(); // 현재 시각을 밀리초 단위로 구하는 메서드
        for(long i = 0; i< count; i++) {
            obj.toString();
        }
        System.out.println(msg + ": END");
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start_time) + "msec.");
    }

    static class NotSynch {
        private final String name = "NotSynch";
        public String toString() {
            return "[ "+name+" ]";
        }
    }

    static class Synch {
        private final String name = "Synch";
        public synchronized String toString() {
            return "[" + name + "]";
        }
    }
}
/**
 * 실제로 코딩된 내용이 동일해도, synchronized 키워드만 붙이면 대략 67배 느림
 */
