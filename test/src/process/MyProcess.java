package process;

import java.util.LinkedList;
import java.util.Queue;

public class Process {
    Queue<Property> ProcessColletion = new LinkedList<>();

    Process() {
        Property propertyA = new Property("프로세스 A", 0, 3);
        Property propertyB = new Property("프로세스 B", 0, 5);
        Property propertyC = new Property("프로세스 C", 0, 7);
        Property propertyD = new Property("프로세스 D", 0, 10);
        Property propertyE = new Property("프로세스 E", 0, 15);
    }


}
