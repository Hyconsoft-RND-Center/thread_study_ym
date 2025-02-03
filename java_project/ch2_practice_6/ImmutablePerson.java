package java_project.ch2_practice_6;

public final class ImmutablePerson {
    private final String name;
    private final String address;
    public ImmutablePerson(String name, String address) {
        this.name= name;
        this.address= address;
    }
    //TODO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 여기
    public ImmutablePerson(MutablePerson person) {
        this.name = person.getName();
        this.address = person.getAddress();
    }
    public MutablePerson getMutablePerson() {
        return new MutablePerson(this);
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String toString() {
        return "[ ImmutablePerson: " + name +", " + address +" ]";

    }
}
