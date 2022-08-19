package MutilthreadedWebcrawler;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CrawlerBlockingQueue implements Crawler {
    @Override
    public void crawl(Fetcher fetcher, Set<String> visited, String url) throws InterruptedException {
        BlockingQueue<String[]> ch = new LinkedBlockingDeque<>();
        ch.add(new String[]{url});
        master(fetcher, visited, ch);
    }
    private void master(Fetcher fetcher, Set<String> visited, BlockingQueue<String[]> ch) throws InterruptedException {
        int n = ch.size();
        while (true){
            String[] urls = ch.take();
            for(String url: urls) {

                if (!visited.contains(url)) {
                    visited.add(url);
                    n++;
                    new Thread(() -> {
                        try {
                            slave(url, ch, fetcher);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
                n--;
                if (n == 0) {
                    return;
                }
            }
        }
    }

    private void slave(String url, BlockingQueue<String[]> ch, Fetcher fetcher) throws InterruptedException {
        List<String> ls = fetcher.fetch(url);
        ch.put(ls.toArray(new String[ls.size()]));
        return;
    }





}
