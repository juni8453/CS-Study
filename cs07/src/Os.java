import java.util.LinkedList;
import java.util.Queue;

public class Os {

    private final Queue<Process> readyQueue = new LinkedList<>();

    // 프로세스를 3개 생성하고 대기 큐에 담아준다.
    public void init() {
        readyQueue.offer(new Process("PCB A", 3));
        readyQueue.offer(new Process("PCB B", 5));
        readyQueue.offer(new Process("PCB C", 7));
    }

    // -> 스케줄러에 전달
    public void passProcesses() {
        Scheduler scheduler = new Scheduler(readyQueue);
        scheduler.roundRobin();
    }

}
