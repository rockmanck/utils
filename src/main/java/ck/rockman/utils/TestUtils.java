package ck.rockman.utils;

import ck.rockman.Procedure;
import org.junit.jupiter.api.Assertions;

public class TestUtils {

    private TestUtils() {
        // hide public constructor
    }

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
            Assertions.assertTrue(false, "Procedure should fail");
        } catch (Exception e) {
            Assertions.assertTrue(expectedException.isInstance(e));
        }
    }
}
