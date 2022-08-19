package Rubrik;

import Rubrik.model.Request;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class IncomingRequestCountTest {
    IncomingRequestCount incomingRequestCount;

    @Before
    public void setup(){
        incomingRequestCount = new IncomingRequestCount();
    }

    @Test
    public void getCountTest() throws InterruptedException {
        int MX = 100000;

        Request request = new Request("what", new Date());
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < MX; i++) {
                incomingRequestCount.addCount(request);
            }
        });
        thread1.start();
        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < MX; i++) {
                incomingRequestCount.decreaseCount(request);
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(incomingRequestCount.getCount(request));

        assert incomingRequestCount.getCount(request).equals(0);

    }
}
