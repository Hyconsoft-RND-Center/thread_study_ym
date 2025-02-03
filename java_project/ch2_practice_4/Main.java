package java_project.ch2_practice_4;

public class Main {
    public static void main(String[] args) {
        StringBuffer bufferObj = new StringBuffer("Hello");

        MyTestClass testObj = new MyTestClass(bufferObj);

        System.out.println("testObj 초기 상태" + testObj.getStringBuffer());
        
        bufferObj.append(" World!");
        
        System.out.println("testObj 변경 후 상태" + testObj.getStringBuffer());
    }

    static final class MyTestClass {
        private final StringBuffer string;
        public MyTestClass(StringBuffer string) {
            this.string = string;
        }
        public StringBuffer getStringBuffer() {
            return string;
        }
    }
}
/**
 * final 필드 및 final 클래스로 가드를 해도, immutable 하지 않은 StringBuffer 클래스를 사용하여 문자열 데이터를 저장했으므로 immutable 하지않다.
 */

