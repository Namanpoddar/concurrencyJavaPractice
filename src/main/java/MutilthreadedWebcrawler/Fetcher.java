package MutilthreadedWebcrawler;

import java.util.*;

public class Fetcher {
    private Random random = new Random();
    private int maxSize = 5;
    private int maxCount = 1000;
    private int maxSleepTime = 10;

    public Set<String> allThread = new HashSet<>();

    public List<String> fetch(String url) throws InterruptedException {
        int size = random.nextInt(maxSize);
        List<String> ls = new ArrayList<>();
        for(int i = 0; i < size;i++){
            allThread.add(Thread.currentThread().getName());
            Thread.sleep(random.nextInt(maxSleepTime));
            ls.add(String.valueOf(random.nextInt(maxCount)));
        }
        return ls;
    }

}
