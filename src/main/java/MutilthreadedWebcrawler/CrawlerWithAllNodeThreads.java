package MutilthreadedWebcrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class CrawlerWithAllNodeThreads implements Crawler {
    Semaphore semaphore = new Semaphore(1);


    @Override
    public void crawl(Fetcher fetcher, Set<String> visited, String url) throws InterruptedException {
        semaphore.acquire();
        boolean already = visited.contains(url);
        visited.add(url);
        semaphore.release();
        if(already) return;

        List<String> fetched = fetcher.fetch(url);
        List<Thread> list = new ArrayList<>();
        for(String child: fetched){
            Thread thread = new Thread(()-> {
                try {
                    crawl(fetcher, visited,child);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            list.add(thread);
            thread.start();
        }
        for(Thread thread: list){
            thread.join();
        }

        return;


    }
}
