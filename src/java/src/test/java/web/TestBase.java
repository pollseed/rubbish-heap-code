package TestCode.TestCode;

import java.util.function.Predicate;
import java.util.stream.Stream;

public interface TestBase {
    <T> void l(T str);

    <T> void ln(T str);

    <T> void lns(Stream<T> stream);

    <T> void lns(T[] strs);

    <T> void lns(Predicate<? super T> predicate, Stream<T> stream);

    <T> void lns(Predicate<? super T> predicate, T[] strs);
}
