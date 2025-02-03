package java_project.ch2_practice_2;

public class Main {
    public static void main(String[] args) {
        String test = "BAT";

        System.out.println("원본 : " + test);
        System.out.println("B를 C로 치환한 변경값 : " + test.replace("B", "C"));
        System.out.println("원본 == 변경값 ? " + (test == test.replace("B", "C")));

    }
}
/**
 * 예시를 보면 알겠지만, replace는 필드의 값을 변형하여 리턴하는 것 뿐 원본 값은 변경되지 않았음을 알 수 있다. (맨 아래 참고)
 */ 
