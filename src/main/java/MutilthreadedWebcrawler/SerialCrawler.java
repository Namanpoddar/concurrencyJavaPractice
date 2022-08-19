package MutilthreadedWebcrawler;

import java.util.List;
import java.util.Set;

public class SerialCrawler {
    public void crawl(Fetcher fetcher, Set<String> visited, String url) throws InterruptedException {
        if(visited.contains(url)){
            return;
        }
        visited.add(url);
        List<String> children = fetcher.fetch(url);
        for(String child: children){
            crawl(fetcher, visited, child);
        }
        return;
    }
}
