import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Scheduler {

    // 스케줄러에는 대기 큐 리스트와 종료된 프로세스 리스트가 존재한다.
    private final Queue<Process> readyQueue;
    // FIFO 먼저 줄 선 애가 먼저 나옴
    //
    private final List<Process> terminatedProcesses;

    // 스케줄러 생성 시 OS에서 받아온 대기 큐를 옮겨주고, 종료된 프로세스 리스트를 새로 생성해준다.
    public Scheduler(Queue<Process> readyQueue) {
        this.readyQueue = readyQueue;
        this.terminatedProcesses = new ArrayList<>();
    }


    public void roundRobin() {
        //todo
        // OS 에게 전달받은 프로세스 3개 담은 대기 큐를 사용하면 될 듯.

        while(!readyQueue.isEmpty()) {
            Process runningProess = readyQueue.poll();

            //todo
            // ready Queue 에서 RR (Round Robin) 1초동안 process CPU 할당,
            // 꺼낸 runningProcess State 를 running으로 바꿔줌
            // runningProcess 실행 (= CPU 할당)

            try {
                Thread.sleep(1000);
                //todo
                // 1초 후에는 Process로부터 cpu 빼앗음

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 아직 종료되기 전이면 ready Queue에 다시 넣고 Process가 running타임이 다 되면 terminatedProcesses 에 넣고 ready Queue에는 넣지 말아야 함
            if (runningProess.isTerminated()) {
                //todo ready Queue에 넣지 말고 terminatedProcess에 넣어
                // status => terminated

            } else {
                //todo ready Queue에 다시 넣어
                // 할당시간이 남은 애들 (= 프로그램이 아직 다 실행 안된 애들)
                // status => waiting

            }
        }


    }

}
