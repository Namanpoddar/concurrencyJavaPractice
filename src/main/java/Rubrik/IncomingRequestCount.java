package Rubrik;

import Rubrik.model.Request;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class IncomingRequestCount {
    ConcurrentHashMap<Request, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public void addCount(Request request){
        concurrentHashMap.compute(request, (key, oldValue)
                -> oldValue == null ? 1 :  oldValue + 1);
    }

    public void decreaseCount(Request request){
        concurrentHashMap.compute(request, (key, oldValue)
                -> oldValue == null  ? -1 :  oldValue - 1);
    }

    public Integer getCount(Request request){
        return  concurrentHashMap.get(request);
    }


}
