package java_project.ch2_practice_6;

public final class MutablePerson {
    private String name;
    private String address;
    public MutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public MutablePerson(ImmutablePerson person) {
        this.name = person.getName();
        this.address = person.getAddress();
    }
    public synchronized void setPersone(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
    }
    public synchronized ImmutablePerson getImmutablePerson() {
        return new ImmutablePerson(this);
    }
    // ** public 도 private 도 아닌 메소드는 같은 패키지만 엑세스가 가능하다!
    String getName() {
        return name;
    }
    String getAddress() {
        return address;
    }
    public synchronized String toString() {
        return "[ MutablePerson: " + name +", " + address +" ]";
    }
}
