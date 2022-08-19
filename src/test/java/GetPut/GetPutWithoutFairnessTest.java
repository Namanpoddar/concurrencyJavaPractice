package GetPut;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetPutWithoutFairnessTest {
    GetPutWithPutStarvation getPutWithPutStarvation;
    GetPutReaderWriter getPutReaderWriter;
    @Test
    public void test1() throws InterruptedException {
        getPutWithPutStarvation = new GetPutWithPutStarvation();
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(()-> {
                try {
                    getPutWithPutStarvation.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            threadList.add(thread);
        }


        Thread putThread = new Thread(()-> {
            try {
                getPutWithPutStarvation.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        putThread.start();
        threadList.add(putThread);


        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(()-> {
                try {
                    getPutWithPutStarvation.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            threadList.add(thread);
        }

        for(Thread thread : threadList){
            thread.join();
        }
    }


    @Test
    public void test2() throws InterruptedException {
        getPutReaderWriter = new GetPutReaderWriter();
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(()-> {
                try {
                    getPutReaderWriter.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            threadList.add(thread);
        }


        Thread putThread = new Thread(()-> {
            try {
                getPutReaderWriter.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        putThread.start();
        threadList.add(putThread);


        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(()-> {
                try {
                    getPutReaderWriter.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            threadList.add(thread);
        }

        for(Thread thread : threadList){
            thread.join();
        }
    }


}
