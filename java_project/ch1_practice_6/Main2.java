package java_project.ch1_practice_6;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit");

        // Tool 클래스로 spoon 과 fork 인스턴스 생성 
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");

        new EaterThread2("Alice", spoon, fork).start();
        new EaterThread2("Bobby", fork, spoon).start();
    }
}
