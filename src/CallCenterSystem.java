// CallCenterSystem.java
import java.util.LinkedList;
import java.util.Queue;

public class CallCenterSystem {
    private Queue<Caller> callQueue = new LinkedList<>();
    private int callerId = 1;

    public void addCaller(String name, String issue) {
        callQueue.add(new Caller(callerId++, name, issue));
    }

    public Caller serveCaller() {
        return callQueue.poll();
    }

    public Queue<Caller> getQueue() {
        return callQueue;
    }

    public int getQueueSize() {
        return callQueue.size();
    }
}
