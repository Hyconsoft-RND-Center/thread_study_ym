package java_project.ch2_practice_5;

public class Main {
    public static void main(String[] args) {
        Point start = new Point(0, 0);
        Point end = new Point(10, 10);
        Line oriLine = new Line(start,end);
        System.out.println("초기값 : "+ oriLine);;

        start.x = 20;
        start.y = 20;

        System.out.println("????? : "+ oriLine);;
    }

    static class Line {
        private final Point startPoint;
        private final Point endPoint;
        public Line(int startx, int starty, int endx, int endy) {
            this.startPoint = new Point(startx, starty);
            this.endPoint=  new Point(endx, endy);
        }
        public Line(Point startPoint, Point endPoint) {
            this.startPoint=startPoint;
            this.endPoint=endPoint;
        }
        public String toString() {
            return "[ Line: "+ startPoint + "-" +endPoint + "]";
        }
    }

    static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x= x;
            this.y = y;
        }
        public int getX() { return x; }
        public int getY() { return y; }
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
/**
 * immutable 하지 않음 => 
 * Point 클래스 필드가 public으로 선언되어 외부에서 상태 변경할 수 있음
 */

