package TestCode.TestCode;

import junit.framework.TestCase;

public class TestBaseStandard extends TestCase {
    protected static final TestBase T;
    static {
        T = TestBaseFactory.getInstance();
    }
}
