package MultithreadedWebCrawler;

import MutilthreadedWebcrawler.CrawlerWithAllNodeThreads;
import MutilthreadedWebcrawler.Fetcher;
import MutilthreadedWebcrawler.SerialCrawler;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CrawlerWithAllNodeThreadsTest {
    CrawlerWithAllNodeThreads crawlerWithAllNodeThreads;

    @Before
    public void setup(){
        crawlerWithAllNodeThreads = new CrawlerWithAllNodeThreads();
    }
    @Test
    public void crawlTest(){
        Set<String> urls = new HashSet<>();
        Fetcher fetcher = new Fetcher();
        try {
            crawlerWithAllNodeThreads.crawl(fetcher, urls, "0");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(urls);
        System.out.println(urls.size());
        System.out.println(fetcher.allThread.size());

    }

}
