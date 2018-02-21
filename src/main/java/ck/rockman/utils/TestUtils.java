package ck.rockman.utils;

import ck.rockman.Procedure;

import static org.junit.Assert.assertTrue;

public class TestUtils {
    public static void checkExpectedFailure(Procedure procedure, Class<? extends Exception> expectedException) {
        if (expectedException != null) {
            checkThatFails(procedure, expectedException);
        } else {
            procedure.process();
        }
    }

    private static void checkThatFails(Procedure procedure, Class<? extends Exception> expectedException) {
        try {
            procedure.process();
            assertTrue("Procedure should fail", false);
        } catch (Exception e) {
            assertTrue(expectedException.isInstance(e));
        }
    }
}
