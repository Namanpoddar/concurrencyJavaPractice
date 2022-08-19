//package customDataStructure;
//
//import java.util.Stack;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class CustomStack<O> {
//    private final int maxSize;
//    private Stack<O> st = new Stack<>();
//    private Lock lock = new ReentrantLock();
//    private Condition condition = lock.newCondition();
//    public CustomStack(Integer maxSize){
//        this.maxSize = maxSize;
//    }
//
//    public void push(O el) throws InterruptedException {
//        lock.lock();
//        while (st.size() == maxSize){
//            condition.await();
//        }
//
//    }
//
//
//
//
//}
