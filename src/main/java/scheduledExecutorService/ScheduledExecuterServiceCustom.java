package scheduledExecutorService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ScheduledExecuterServiceCustom{
    ExecutorService executorService = Executors.newFixedThreadPool(16);


    public void schedule(Runnable command, long delay, TimeUnit unit) throws InterruptedException {
        Thread.sleep(delay);
        command.run();
    }


    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) throws InterruptedException {
        Thread.sleep(initialDelay);
        executorService.submit(command);
        Thread.sleep(period);
        scheduleAtFixedRate(command, 0, period, unit);

    }

    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {

    }


}
