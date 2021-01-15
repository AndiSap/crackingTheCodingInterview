package testLogger;

public class TestLogger {
    String testClass;

    public TestLogger(Object currentClass) {
        testClass = currentClass.getClass().getSimpleName();
    }

    public void log(String message) {
        System.out.println(testClass + ": " + message);
    }
}
