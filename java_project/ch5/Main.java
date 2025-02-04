package java_project.ch5;

public class Main {
    /**
     * Producer-Consumer Pattern
     * @param args
     */
    public static void main(String[] args) {
        // 케잌 = data (producer에 의해 만들어지고, consumer에 의해 사용됨)
        // 테이블 = channel (producer로 부터 data를 받아 보관, consumer가 요구하면 data를 제공. 안정성을 위해 producer와 consumer 각각을 배타 제어)
        Table table = new Table(3); //테이블 요리 3개까지 가능 // 데이터 큐

        // 요리사 // Producer
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 92653).start();
        new MakerThread("MakerThread-3", table, 58979).start();

        // 손님 // Consumer
        new EaterThread("EaterThread-1", table, 32384).start();
        new EaterThread("EaterThread-2", table, 62643).start();
        new EaterThread("EaterThread-3", table, 38327).start();

    }
}
