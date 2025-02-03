package java_project.ch1_practice_6;

public class EaterThread3 extends Thread {
    private String name;
    private final Tool lefthand;
    private final Tool righthand;
    public EaterThread3(String name, Tool lefthand, Tool righthand) {
        this.name = name;

        Tool tempLefthand;
        Tool tempRighthand;
        
        if(lefthand == null) {
            tempLefthand = new Tool(name+ "fork");
        } else {
            tempLefthand = lefthand;
        }

        if(righthand == null) {
            tempRighthand = new Tool(name+ "fork");
        } else {
            tempRighthand = righthand;
        }

        // System.out.println("================================================="+ name + "???????" + tempLefthand + tempRighthand);
    
        this.lefthand = tempLefthand;
        this.righthand = tempRighthand;
    }

    public void run() {
        while (true) {
            eat();
        }
    }
    
    public void eat() {
        // 이 곳을 지나는 순간 lefthand에 저장된 Tool 클래스의 인스턴스에 대한 lock 획득
        // 하지만, lefthand에 저장된 Tool 클래스의 인스턴스는 뭐가 들어올지 모름 
        // = 따라서, 여러 쓰레드에서 이 곳을 지날때 lock을 획득한 인스턴스가 서로 다를 수도 있다는 뜻
        // = 만약 lefthand와 righthand에 저장된 인스턴스가 서로 반대인 쓰레드가 실행중일 경우(현재 Main.java의 상태) 데드락 발생
        // (lefthand lock을 취한 쓰레드가 righthand lock을 취할 수 있는 block을 진입해야하는데 lock이 없어서 계속 무한 대기, 다른 쓰레드도 마찬가지)
        synchronized (lefthand) {
            System.out.println(name + " takes up " + lefthand + " (left).");
            // synchronized (righthand) { // TODO 이 케이스는 righthand의 락이 없어도 됨
                System.out.println(name + " takes up " + righthand + " (right).");
                System.out.println(name + " is eating now, yum yum!");
                System.out.println(name + " puts down " + righthand + " (right).");
            // }
            System.out.println(name + " puts down " + lefthand + " (left).");
        }
    }
}
