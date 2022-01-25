import java.util.LinkedList;
import java.util.Queue;

public class Os {

    private final Queue<Process> processes = new LinkedList<>();

    // 프로세스를 3개 생성하고 대기 큐에 담아준다.
    public void init() {
        processes.offer(new Process("프로세스 A", 3));
        processes.offer(new Process("프로세스 B", 5));
        processes.offer(new Process("프로세스 C", 7));
    }

    // -> 스케줄러에 전달
    public void passProcesses() {
        Scheduler scheduler = new Scheduler(processes);
        scheduler.run();
    }
}
