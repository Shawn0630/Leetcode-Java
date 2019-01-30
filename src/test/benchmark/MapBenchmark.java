import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class MapBenchmark {

    List<Integer> list;

    @Setup
    public void setup() {
        list = new Random().ints(100_000).boxed().collect(toList());
    }

    @Benchmark public int for_loop() {
        int sum = 0;
        for (int i : list) sum += i * i;
        return sum;
    }

    @Benchmark public int summingInt() {
        return list.stream().collect(Collectors.summingInt(x -> x * x));
    }

    @Benchmark public int mapToInt() {
        return list.stream().mapToInt(x -> x * x).sum();
    }

    @Benchmark public int mapToInt_map() {
        return list.stream().mapToInt(x -> x).map(x -> x * x).sum();
    }

    @Benchmark public int map_reduce() {
        return list.stream().map(x -> x * x).reduce((x, y) -> x + y).get();
    }

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }
}