package java_project.ch12;

public class Main {
    /**
     * Active Object Pattern
     */
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice",activeObject).start();
        new MakerClientThread("Bobby",activeObject).start();
        new DisplayClientThread("Alice",activeObject).start();
    }
}
