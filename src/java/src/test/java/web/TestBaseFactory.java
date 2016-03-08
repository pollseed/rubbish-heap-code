package TestCode.TestCode;

import java.io.Serializable;

public class TestBaseFactory implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final TestBase getInstance() {
        return new TestBaseImpl();
    }

}
