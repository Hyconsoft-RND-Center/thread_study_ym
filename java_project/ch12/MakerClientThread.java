package java_project.ch12;

public class MakerClientThread extends Thread{
    private final ActiveObject activeObject;
    private final char fillchar;
    public MakerClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillchar = name.charAt(0);
    }

    public void run() {
        try{
            for(int i=0;true;i++) {
                // 반환 값이 있는 호출
                Result<String> result = activeObject.makeString(i, fillchar);
                Thread.sleep(10);
                String val = result.getResultValue();
                System.out.println(Thread.currentThread().getName() + ": value = " + val);
            }
        } catch(InterruptedException e) {}
    }
}
