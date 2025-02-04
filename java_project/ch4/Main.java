package java_project.ch4;

// TODO 목표 4~8 완료 +a
public class Main {
    /**
     * Balking Pattern
     * @param args
     */
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");

        // TODO 실행시 중복 발생 -> 없앨 수 없나? -> 오타인듯 고침 
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
