package java_project.ch9;

// 교환권 역할
public class FutureData implements Data {
    private RealData realData = null;
    private boolean ready = false;

    // synchronized setter
    public synchronized void setRealData(RealData realdata) {
        System.out.println("FutureData setRealData BEGIN ready? ="+ ready);
        if(ready) {
            // ready 가 true일 때만 중단
            return; // balk
        }
        this.realData= realdata;
        this.ready = true;
        notifyAll();
        
        System.out.println("FutureData setRealData END ready? ="+ ready);
    }
    
    public synchronized String getContent() {
        System.out.println("FutureData getContent BEGIN ready? ="+ ready);
        // setRealData에서 notifyAll로 깨워진 쓰레드들이 다시 인스턴스 락을 취해서 while문 반복 => ready 되면 빠져나가고 반환하는 거임
        while (!ready) {
            try{
                wait();
            }catch(InterruptedException e) {}
        }

        System.out.println("FutureData getContent END ready? ="+ ready);
        return realData.getContent();
    }
}
