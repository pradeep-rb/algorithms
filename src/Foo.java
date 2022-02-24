import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Foo {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).toString());
    }
}
