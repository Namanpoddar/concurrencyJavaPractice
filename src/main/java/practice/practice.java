package practice;


public class practice {
    public static void main(String args[]) throws InterruptedException {
        Thread temp = new Thread(() ->{
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(Thread.currentThread());
        });
        temp.start();

        temp.join();
        temp.interrupt();
        System.out.println(Thread.currentThread());

    }

}
