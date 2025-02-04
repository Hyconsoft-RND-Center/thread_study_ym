package java_project.ch9;

public class Host {
   public Data request(final int count, final char c) {
    System.out.println("    request(" + count + ", " + c + ") BEGIN");
    
    // (1) FutureData의 인스턴스를 만든다.
    final FutureData future = new FutureData();
    
    // (2) RealData의 인스턴스를 만들기 위한 새로운 쓰레드를 기동한다.
    new Thread() {
        public void run() {
            System.out.println("????????? 여기서부터"+c);
            RealData realData = new RealData(count, c); // 이 라인 처리에 시간이 걸림
            System.out.println("????????? 여기까지 오래걸림"+c);

            future.setRealData(realData); // TODO 여기 처리에 의문 -> FutureData 로직 이해 미숙 
        }
    }.start();
    
    System.out.println("    request(" + count + ", " + c + ") END");

    // (3) FutureData의 인스턴스를 반환 값으로 한다.
    return future;
   }
}
