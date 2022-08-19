package GetPut;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GetPutReaderWriter {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);
    private final int  mxPermit = 100000;
    private Lock reader = readWriteLock.readLock();
    private Lock writer = readWriteLock.writeLock();

    public void get() throws InterruptedException {
        reader.lock();
        Thread.sleep(10);
        System.out.println("GetCalled");
        reader.unlock();
    }
    public void put() throws InterruptedException {
        writer.lock();
        Thread.sleep(5000);
        System.out.println("PutCalled");
        writer.unlock();
    }
}
