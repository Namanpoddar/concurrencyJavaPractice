package GetPut;

import java.util.concurrent.Semaphore;

public class GetPutWithPutStarvation {
    private final int  mxPermit = 100000;
    Semaphore semaphore = new Semaphore(mxPermit);

    public void get() throws InterruptedException {
        semaphore.acquire(1);
        Thread.sleep(10);
        System.out.println("GetCalled");
        semaphore.release(1);
    }
    public void put() throws InterruptedException {
        semaphore.acquire(mxPermit);
        Thread.sleep(5000);
        System.out.println("PutCalled");
        semaphore.release(mxPermit);
    }



}
