package TestCode.TestCode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

public class TestTestBase extends TestBaseStandard {
    private static ByteArrayOutputStream __out = new ByteArrayOutputStream();
    static {
        System.setOut(new PrintStream(__out));
    }

    @Test
    public void test$1() {
        T.l("1 hoge ");
        test$1("1 hoge ");
        T.ln("2 hoge");
        test$1("2 hoge\r\n");
        T.lns(new String[] { "3 hoge", "3 fuga", "3 piyo" });
        test$1("3 hoge\r\n3 fuga\r\n3 piyo\r\n");
        T.lns(Arrays.stream(new String[] { "4 hoge", "4 fuga", "4 piyo" }));
        test$1("4 hoge\r\n4 fuga\r\n4 piyo\r\n");
        T.lns(string -> !string.isEmpty(), new String[] { "5 hoge", "", "5 piyo" });
        test$1("5 hoge\r\n5 piyo\r\n");
        T.lns(string -> string.isEmpty(), Arrays.stream(new String[] { "", "", "", "", "", "" }));
        test$1("\r\n\r\n\r\n\r\n\r\n\r\n");
    }

    private void test$1(final String str) {
        assertThat(__out.toString(), is(str));
        __out.reset();
    }
}
