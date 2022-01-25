import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Scheduler {

    // 스케줄러에는 대기 큐 리스트와 종료된 프로세스 리스트가 존재한다.
    private final Queue<Process> processes;
    private final List<Process> terminatedProcesses;

    // 스케줄러 생성 시 OS에서 받아온 대기 큐를 옮겨주고, 종료된 프로세스 리스트를 새로 생성해준다.
    public Scheduler(Queue<Process> processes) {
        this.processes = processes;
        this.terminatedProcesses = new ArrayList<>();
    }

    // OS 에게 전달받은 프로세스 3개 담은 대기 큐를 사용하면 될 듯.
    // 대기 큐의 
    public void run() {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {

    }
}
