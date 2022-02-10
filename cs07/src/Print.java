import java.util.List;

public class Print {
    public static void printStatus(List<Process> printProcesses) {
        for (Process printProcess : printProcesses) {
            System.out.println(printProcess);
        }
    }
}
