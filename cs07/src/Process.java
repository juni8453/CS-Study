public class Process {
    private final String processName;
    private final int runningTime; // 5
    private int currentTime; // 스케줄러가 할당해준 CPU 시간 3 6 -> terminated
    private Status processStatus;

    // 각 프로세스의 메인 쓰레드
    private MyThread myThread;

    // 프로세스 생성 때 이름, 러닝 타임을 받아오고, status 는 최초 READY, 현재 동작시간은 0 으로 설정
    public Process(String processName, int runningTime) {
        this.processName = processName;
        this.runningTime = runningTime;
        this.processStatus = Status.READY;
        this.currentTime = 0;
        this.myThread = new MyThread();
    }

    public void run() {

        // todo
        //  만약에 프로세스가 한번이라도 start 되었다면, suspend() 상태니까 resume() 해줘야 한다.
        //  그게 아니라면 start()
        if (this.currentTime != 0) {
            myThread.resume();
        } else {
            myThread.start();
        }

        currentTime++;
    }

    public boolean isTerminated() {
        return currentTime >= runningTime;
    }

    public void changeTerminated() {
        processStatus = Status.TERMINATED;
    }

    public void changeWaiting() {
        processStatus = Status.WAITING;
    }

    public boolean checkStatus() {
        if (processStatus == Status.READY || processStatus == Status.WAITING) {
            processStatus = Status.RUNNING;

            return true;
        }

        return false;
    }

    public void getCpu() {
        myThread.suspend();
    }

    public void killProcess() {
        myThread.stop();
    }

    @Override
    public String toString() {
        return "Process{" +
                "processName='" + processName + '\'' +
                ", runningTime=" + runningTime +
                ", currentTime=" + currentTime +
                ", processStatus=" + processStatus +
                '}';
    }

    enum Status {
        READY("ready"),
        WAITING("waiting"),
        RUNNING("running"),
        TERMINATED("terminated");

        private String currentStatus;

        Status(String currentStatus) {
            this.currentStatus = currentStatus;
        }
    }
}
