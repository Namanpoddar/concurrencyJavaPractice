package waitAndNotify;

import org.junit.Before;
import org.junit.Test;

public class WaitAndNotifyTest {
    WaitAndNotify waitAndNotify;

    @Before
    public void setup(){
        waitAndNotify = new WaitAndNotify(15);
    }

    @Test
    public void test() throws InterruptedException {
        Thread buzz = new Thread(()-> {
            try {
                waitAndNotify.buzz(()->System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread fizz = new Thread(()-> {
            try {
                waitAndNotify.fizz(()->System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread fizzBuzz = new Thread(()-> {
            try {
                waitAndNotify.fizzbuzz(()->System.out.println("fizzBuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread number = new Thread(()-> {
            try {
                waitAndNotify.number((i)->System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fizz.start();
        buzz.start();
        fizzBuzz.start();
        number.start();
        fizz.join();
        buzz.join();
        fizzBuzz.join();
        number.join();
    }

}
