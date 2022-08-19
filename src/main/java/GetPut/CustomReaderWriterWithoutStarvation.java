package GetPut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.*;

public class CustomReaderWriterWithoutStarvation {
    private Boolean isWriting = false;
    private Boolean isWriteWaiting = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int totalReadCount = 0;

    public void readerLock() throws InterruptedException {
        lock.lock();
        while(isWriting || isWriteWaiting){
            condition.await();
        }
        totalReadCount+=1;
        lock.unlock();
    }
    public void readerUnLock(){
        lock.lock();
        totalReadCount -= 1;
        if(totalReadCount==0){
            condition.signalAll();
        }
        lock.unlock();
    }
    public void writerLock() throws InterruptedException {
        lock.lock();
        isWriteWaiting = true;
        while (isWriting || totalReadCount != 0){
            condition.await();
        }
        isWriteWaiting = false;
        isWriting = true;
        lock.unlock();
    }
    public void writerUnLock(){
        lock.lock();
        isWriting = false;
        condition.signalAll();
        lock.unlock();
    }
}
