package process;

import java.util.*;

public class MyProcess {
    private final Queue<Property> processColletion = new LinkedList<>();
    private final List<Property> processShuffle = new ArrayList<>();

    // 프로세스 섞기
    public Queue<Property> listShuffle() {
        for (int i = 0; i < 5; i++) {
            processShuffle.add(new Property("프로세스 A", 0, 3, "ready"));
            processShuffle.add(new Property("프로세스 B", 0, 5, "ready"));
            processShuffle.add(new Property("프로세스 C", 0, 7, "ready"));
            processShuffle.add(new Property("프로세스 D", 0, 10,"ready"));
            processShuffle.add(new Property("프로세스 E", 0, 15,"ready"));
        }

        Collections.shuffle(processShuffle);

        // 섞은 프로세스 앞에서 3개를 Queue 에 담기
        for (int i = 0; i < 3; i++) {
            processColletion.offer(processShuffle.get(i));
        }

        return processColletion;
    }
}
