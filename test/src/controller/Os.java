package controller;

import process.Property;
import java.util.Queue;

// TODO Thread 사용 ?
//  프로세스 이름(프로세스 상태), 누적 동작 시간 / 최대 동작 시간
//  프로세스 이름(프로세스 상태), 누적 동작 시간 / 최대 동작 시간
//  프로세스 이름(프로세스 상태), 누적 동작 시간 / 최대 동작 시간
//  . (1초)

public class Os {
    private final Property processA;
    private final Property processB;
    private final Property processC;

    public Os(Queue<Property> processCollections) {
        this.processA = processCollections.poll();
        this.processB = processCollections.poll();
        this.processC = processCollections.poll();
    }

    public int sumRunTime() {
        return processA.getMaxRunTime() + processB.getMaxRunTime() + processC.getMaxRunTime();
    }

    public void osRun() {
        for (int i = 0; i < sumRunTime(); i++) {
            System.out.println(processA.toString());
            System.out.println(processB.toString());
            System.out.println(processC.toString());
            System.out.println(".");

            //TODO
        }
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {

    }
}

class ThreadB extends Thread {
    @Override
    public void run() {

    }
}

class ThreadC extends Thread {
    @Override
    public void run() {

    }
}
