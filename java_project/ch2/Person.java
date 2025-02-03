package java_project.ch2;

// 서브 클래스를 만들 수 없도록 final 선언 => Immutable 패턴을 위한 예방적 조치
public final class Person {
    // private 선언으로 외부에서 값을 변경하지 못하게 함 => Immutable 패턴을 위한 예방적 조치
    private final String name; // final 선언으로 값 재대입 불가능하게 함 => Immutable 패턴을 위한 예방적 조치
    private final String address;

    public Person(String name, String address) {
        this.name=name;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "[ Person: name = " + name + " , address = " + address + " ]";
    }
}
