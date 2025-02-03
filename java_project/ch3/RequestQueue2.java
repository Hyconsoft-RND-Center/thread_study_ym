package java_project.ch3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// java.util.concurrent.LinkedBLockingQueue 적용
public class RequestQueue2 {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    public Request getRequest() {
       Request req = null;
       try{
        req= queue.take();
       }catch(InterruptedException e){}
       return req;
    }

    public synchronized void putRequest(Request request) {
        try{
            queue.put(request);
        } catch(InterruptedException e) {}
    }
}
