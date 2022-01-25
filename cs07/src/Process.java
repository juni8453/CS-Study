public class Process {
    private final String processName;
    private final int runningTime; // 5
    private int currentTime; // 스케줄러가 할당해준 CPU 시간 3 6 -> terminated
    private Status processStatus;
    private boolean isRun;

    // 각 프로세스의 메인 쓰레드
    private MyThread myThread;

    // 프로세스 생성 때 이름, 러닝 타임을 받아오고, status 는 최초 READY, 현재 동작시간은 0 으로 설정
    public Process(String processName, int runningTime) {
        this.processName = processName;
        this.runningTime = runningTime;
        this.processStatus = Status.READY;
        this.currentTime = 0;
        this.isRun = true;
        this.myThread = new MyThread();
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

    // 프로세스는 4가지의 상태 중 하나
    // 각 상태에서 변화할 수 있는 기능을 지니고 있어야 한다.
    // TODO ready 에서는 running or waiting 상태로 변화할 수 있다.
    //  자기가 실행 순서라면 running, 아니라면 waiting 으로 바껴야 하는데 이걸 어떻게 판단하나 ??
    //  boolean Type isRun 으로 판단해보자 일단은 (Test)

    public Status changeStatus() {
//        if (this.processStatus == Status.READY) {
//            // 자기 차례라면 Running
//            if (isRun) {
//                this.processStatus = Status.RUNNING;
//                    // 실행 후 끝났는 지 전부 끝났는지 판단
//                    endProcess();
//            }
//
//            // 자기 차례가 아니라면 Waiting
//            if (!isRun) {
//                this.processStatus = Status.WAITING;
//            }
//        }
//
//        return processStatus;
        return Status.READY;
    }

    public boolean isTerminated() {
        return currentTime >= runningTime;
    }

    public void endProcess() {
        if (this.currentTime == this.runningTime) {
            this.processStatus = Status.TERMINATED;
        }
    }

    public void run() {
        // TODO 만약에 프로세스가 한번이라도 start 되었다면, suspend() 상태니까 resume() 해줘야 한다.
        //  그게 아니라면 start()
        if (this.currentTime != 0) {
            myThread.resume();
        } else {
            myThread.start();
        }

        currentTime++;
    }
}
