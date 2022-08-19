package MutilthreadedWebcrawler;

import java.util.Set;

public interface Crawler {
    public void crawl(Fetcher fetcher, Set<String> visited, String url) throws InterruptedException;
}
