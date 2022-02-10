package controller;

import process.MyProcess;
import process.Property;

import java.util.Queue;

public class MainController {
    public static void main(String[] args) {
        MyProcess process = new MyProcess();
        Queue<Property> processCollections = process.listShuffle();

        Os os = new Os(processCollections);
        os.osRun();
    }
}
