package customDataStructure;

import org.junit.Test;

public class CustomBlockingQueueTest {
    CustomBlockingQueue<Integer> customBlockingQueue;

    @Test
    public void test() throws InterruptedException {
        customBlockingQueue = new CustomBlockingQueue(2);

        Thread thread1 = new Thread(()-> {
            try {
                System.out.println("get0");
                customBlockingQueue.take();
                System.out.println("get1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()-> {
            try {
                Thread.sleep(1000);
                System.out.println("what");
                customBlockingQueue.put(0);
                System.out.println("what0");
                customBlockingQueue.put(1);
                System.out.println("what1");
                customBlockingQueue.put(2);
                System.out.println("what2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}
