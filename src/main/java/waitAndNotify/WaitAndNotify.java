package waitAndNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class WaitAndNotify {
    private int n;
    private int i;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public WaitAndNotify(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        while(i <= n){
            if(i%3 != 0 || i%5 == 0){
                condition.await();
                continue;
            }
            printFizz.run();
            i++;
            condition.signalAll();
        }
        lock.unlock();
    }

    public  void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        while(i <= n){
            if(i%5 != 0 || i%3 == 0){
                condition.await();;
                continue;
            }
            printBuzz.run();
            i++;
            condition.signalAll();
        }
        lock.unlock();
    }

    public  void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        while(i <= n){
            if(i%5 != 0 || i%3 != 0){
                condition.await();
                continue;
            }
            printFizzBuzz.run();
            i++;
            condition.signalAll();
        }
        lock.unlock();
    }

    public  void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while(i <= n){
            if(i%3 == 0 || i%5 == 0){
                condition.await();
                continue;
            }
            printNumber.accept(i);
            i++;
            condition.signalAll();
        }
        lock.unlock();
    }


}
