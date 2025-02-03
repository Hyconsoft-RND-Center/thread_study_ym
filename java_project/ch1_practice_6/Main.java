package java_project.ch1_practice_6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit");

        // ====================== 1-1 ======================
        // Tool 클래스로 spoon 과 fork 인스턴스 생성 
        // Tool spoon1 = new Tool("Spoon1");
        // Tool fork1 = new Tool("Fork1");
        // Tool spoon2 = new Tool("Spoon2");
        // Tool fork2 = new Tool("Fork2");

        // new EaterThread("Alice", spoon1, fork1).start();
        // new EaterThread("Bobby", fork2, spoon2).start();
        // ====================== 1-1 ======================

        // ====================== 1-2 ======================
        // Tool 클래스로 spoon 과 fork 인스턴스 생성 
        // Tool spoon = new Tool("Spoon");
        // Tool fork1 = new Tool("Fork1");
        // Tool fork2 = new Tool("Fork2");

        // new EaterThread("Alice", spoon, fork1).start();
        // new EaterThread("Bobby", fork2, spoon).start();

        // =================================================

        // Tool 클래스로 spoon 과 fork 인스턴스 생성 
        Tool spoon = new Tool("Spoon");

        new EaterThread3("Alice", spoon, null).start();
        new EaterThread3("Bobby", null, spoon).start();
        // ====================== 1-2 ======================
    }
}

