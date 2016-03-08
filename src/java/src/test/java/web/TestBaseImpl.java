package TestCode.TestCode;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import junit.framework.TestCase;

public class TestBaseImpl extends TestCase implements TestBase {
    public final <T> void l(final T str) {
        System.out.print(str);
    }

    public final <T> void ln(final T str) {
        System.out.println(str);
    }

    public final <T> void lns(final Stream<T> stream) {
        stream.forEach(str -> ln(str));
    }

    public final <T> void lns(final T[] strs) {
        lns(toStream(strs));
    }

    public final <T> void lns(final Predicate<? super T> predicate, final Stream<T> stream) {
        lns(stream.filter(predicate));
    }

    public final <T> void lns(final Predicate<? super T> predicate, final T[] strs) {
        lns(predicate, toStream(strs));
    }

    private static <T> Stream<T> toStream(final T[] strs) {
        return Arrays.stream(strs);
    }
}
