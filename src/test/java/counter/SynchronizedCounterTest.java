package counter;

import org.junit.Test;

public class SynchronizedCounterTest {
    SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
    @Test
    public void synchronizedCounter() throws InterruptedException {
        int n = 10000;
        Thread t1 = new Thread(()->{
            for(int j = 0; j < n; j++){
                synchronizedCounter.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for(int j = 0; j < n; j++) {
                synchronizedCounter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assert synchronizedCounter.value() == 2*n;

    }

}
