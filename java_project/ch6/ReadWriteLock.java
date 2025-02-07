package java_project.ch6;

public class ReadWriteLock {
    private int readingReaders = 0; // (A) 실제로 읽고 있는 중인 쓰레드 수
    private int waitingWriters = 0; // (B) 쓰기를 기다리고 있는 쓰레드 수 // TODO 왜 필요?
    private int writingWriters = 0; // (C) 실제로 쓰고 있는 중인 쓰레드 수
    private boolean preferWriter = true; //쓰는 것을 우선하면 true, 읽기를 우선하면 false // 쓰레드의 생존성이 약해지는 것을 방지 

    public synchronized void readLock() throws InterruptedException {
        // guarded suspension pattern
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            // 뒤에 조건은 쓰는 쓰레드가 있을 경우 읽는 쓰레드보다 우선 순위를 둠
            wait();
        }
        readingReaders++; // (A) 실제로 읽고 있는 쓰레드의 수를 한개 늘린다.
    }

    public synchronized void readUnlock() {
        readingReaders--; // (A) 실제로 읽고 있는 쓰레드의 수를 한개 줄인다.
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++; // (B) 쓰기를 기다리고 있는 쓰레드의 수를 한개 늘린다.
        try{
            // guarded suspension pattern
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--; // (B) 쓰기를 기다리고 있는 쓰레드의 수를 한개 줄인다.
        }
        writingWriters++; // (C) 실제로 쓰고 있는 쓰레드의 수를 한개 늘린다.
    }

    public synchronized void writeUnlock() {
        writingWriters--; // (C) 실제로 쓰고 있는 쓰레드의 수를 한개 줄인다.
        preferWriter = false;
        notifyAll();
    }
}
