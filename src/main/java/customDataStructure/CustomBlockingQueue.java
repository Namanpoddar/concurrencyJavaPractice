package customDataStructure;

import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class CustomBlockingQueue<O> {
    private final int maxSize;
    private LinkedList<O> linkedList;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock writer = lock.writeLock();
    private Lock reader = lock.readLock();
    private Condition condition = writer.newCondition();
    
    public CustomBlockingQueue(int maxSize){
        this.maxSize = maxSize;
        this.linkedList = new LinkedList();
    }

    public O take() throws InterruptedException {
        writer.lock();
        while(linkedList.size() == 0){
            condition.await();
        }
        O el = linkedList.poll();
        condition.signalAll();
        writer.unlock();
        return el;
    }

    public void put(O el) throws InterruptedException {
        writer.lock();
        while(linkedList.size() == maxSize){
            condition.await();
        }
        linkedList.add(el);
        condition.signalAll();
        writer.unlock();
    }
}
