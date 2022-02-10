import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Scheduler {

    // 스케줄러에는 대기 큐 리스트와 종료된 프로세스 리스트가 존재한다.
    private final Queue<Process> readyQueue;
    private final List<Process> terminatedProcesses;
    private final List<Process> printProcesses;

    // 스케줄러 생성 시 OS에서 받아온 대기 큐를 옮겨주고, 종료된 프로세스 리스트를 새로 생성해준다.
    public Scheduler(Queue<Process> readyQueue) {
        this.readyQueue = readyQueue;
        this.terminatedProcesses = new ArrayList<>();
        this.printProcesses = new ArrayList<>(readyQueue);
    }

    public void scheduleProcess() {

        //todo
        // OS 에게 전달받은 프로세스 3개 담은 대기 큐를 사용하면 될 듯.
        // 구현조건에 스케줄링 실행 시 모든 프로세스를 Waiting 상태로 바꿔줘야 한다.
        // iter (foreach)
        for (Process process : readyQueue) {
            process.changeWaiting();
        }

        while(!readyQueue.isEmpty()) {
            Process runningProess = readyQueue.poll();

            //todo
            // ready Queue 에서 RR (Round Robin) 1초동안 process CPU 할당,
            // 꺼낸 runningProcess State 를 running으로 바꿔줌
            // runningProcess 실행 (= CPU 할당)
            // 프로세스 속성을 확인하고 ready or waiting 속성일 때 running 속성으로 바꿔주고 실행
            if (runningProess.checkStatus()) {
                runningProess.run();
                Print.printStatus(printProcesses);
            }

            try {
                Thread.sleep(1000);

                //todo
                // 1초 후에는 Process로부터 cpu를 뺏으려고 자는 것.. (안재우면 바로 뺏어오기 때문에 안됨)
                // 프로세스에게 자기 쓰레드를 반납하고 명령
                runningProess.getCpu();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (runningProess.isTerminated()) {

                //todo
                // ready Queue에 넣지 말고 terminatedProcess에 넣어야 함
                // status => terminated
                // terminated List 에 집어넣기 전에 속성을 바꿔주고 집어넣기.
                // terminated 가 되면 프로세스를 죽여야 한다.
                runningProess.changeTerminated();
                runningProess.killProcess();
                terminatedProcesses.add(runningProess);


            } else {

                //todo
                // ready Queue에 다시 넣어
                // 할당시간이 남은 애들 (= 프로그램이 아직 다 실행 안된 애들)
                // status => waiting
                runningProess.changeWaiting();
                readyQueue.offer(runningProess);
            }
        }

        Print.printStatus(printProcesses);

        System.out.println("프로그램이 종료되었습니다.");
    }
}
