package ReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPractice<O> {

    private final ReadWriteLock readWriteLock
            = new ReentrantReadWriteLock();
    private final Lock writeLock
            = readWriteLock.writeLock();
    private final Lock readLock = readWriteLock.readLock();
    private final List<O> list = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    public void setElement(O o)
    {
        writeLock.lock();
        try {
            list.add(o);
            System.out.println(
                    "Element by thread "
                            + Thread.currentThread().getName()
                            + " is added");
        }
        finally {
            writeLock.unlock();
        }
    }

    public O getElement(int i)
    {
        readLock.lock();
        try {
            System.out.println(
                    "Elements by thread "
                            + Thread.currentThread().getName()
                            + " is printed");
            return list.get(i);
        }
        finally {
            readLock.unlock();
        }
    }
}
