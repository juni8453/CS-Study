import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class PrimeAlpha {
    private int number;

    public PrimeAlpha(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        PrimeAlpha prime1 = new PrimeAlpha(10);
        PrimeAlpha prime2 = new PrimeAlpha(7);

        System.out.println(prime1.isPrime());
        System.out.println(prime2.isPrime());
    }

    // 소수 판단 메서드
    public boolean isPrime() {
        Set<Integer> primeSet = new HashSet<>();
        primeSet.add(1);
        primeSet.add(number);

        return number > 1 && factors().equals(primeSet);

    }

    // 약수 판단 메서드
    public boolean isFactor(int potentialFactor) {
        return number % potentialFactor == 0;
    }

    public Set<Integer> factors() {
        Set<Integer> factors = new HashSet<>();
        Stream.iterate(1, i -> i + 1)
                .limit((int)Math.sqrt(number))
                .filter(this::isFactor)
                .forEach(i -> {
                    factors.add(i);
                    factors.add(number / i);
                });

        return factors;
    }
}
