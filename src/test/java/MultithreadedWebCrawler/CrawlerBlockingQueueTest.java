package MultithreadedWebCrawler;

import MutilthreadedWebcrawler.CrawlerBlockingQueue;
import MutilthreadedWebcrawler.Fetcher;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CrawlerBlockingQueueTest {
    CrawlerBlockingQueue crawlerBlockingQueue;

    @Before
    public void setup(){
        crawlerBlockingQueue = new CrawlerBlockingQueue();

    }

    @Test
    public void crawlTest() throws InterruptedException {
        Fetcher fetcher = new Fetcher();
        Set<String> urls = new HashSet<>();
        crawlerBlockingQueue.crawl(fetcher, urls, "0");

        System.out.println(urls);
        System.out.println(urls.size());
        System.out.println(fetcher.allThread.size());

    }


}
