import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ClassifierAlpha {
    private final int number;

    public ClassifierAlpha(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        ClassifierAlpha alpha1 = new ClassifierAlpha(10);
        ClassifierAlpha alpha2 = new ClassifierAlpha(6);

        System.out.println(alpha1.isPerfect());
        System.out.println(alpha2.isPerfect());
    }

    // 약수를 판단하고 담아주는 메서드
    public Set<Integer> factors() {
        // TODO for 반복문을 스트림으로 수정
        //  iterate().limit() 로 스트림의 크기가 limit 일 때 까지 반복하여 스트림을 생성한다.
        Set<Integer> factors = new HashSet<>();
        Stream.iterate(1, i -> i + 1)
                .limit((int) Math.sqrt(number))
                .filter(this::isFactor)
                .forEach(i -> {
                    factors.add(i);
                    factors.add(number / i);
                });

        return factors;
    }

    public static int sum(Set<Integer> factors) {
        // TODO 이터레이터를 스트림으로 수정
        return factors.stream()
                .mapToInt(i -> i)
                .sum();
    }

    // 약수 판단 메서드
    public boolean isFactor(int potentialFactor) {
        return number % potentialFactor == 0;
    }

    // 완전수 판단 메서드
    public boolean isPerfect() {
        return sum(factors()) - number == number;
    }

    // 과잉수 판단 메서드
    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    // 부족수 판단 메서드
    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }
}
