package MultithreadedWebCrawler;

import MutilthreadedWebcrawler.Fetcher;
import MutilthreadedWebcrawler.SerialCrawler;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SerialCrawlerTest {
    SerialCrawler serialCrawler;

    @Before
    public void setup(){
        serialCrawler = new SerialCrawler();
    }
    @Test
    public void crawlTest(){
        Set<String> urls = new HashSet<>();
        Fetcher fetcher = new Fetcher();
        try {
            serialCrawler.crawl(fetcher, urls, "0");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(urls);
        System.out.println(fetcher.allThread);
    }

}
