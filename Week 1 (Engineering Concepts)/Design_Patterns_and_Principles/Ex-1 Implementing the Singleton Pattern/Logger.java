public class Logger
{

    // Step 1: Use a static inner class to hold the singleton instance
    private static class LoggerHolder
    {
        private static final Logger INSTANCE = new Logger();
    }

    // Step 2: Make the constructor private to prevent external instantiation
    private Logger()
    {
        System.out.println("Logger initialized");
    }

    // Step 3: Provide a public static method to return the single instance
    public static Logger getInstance()
    {
        return LoggerHolder.INSTANCE;
    }

    // Sample logging method
    public void log(String message)
    {
        System.out.println("Log message: " + message);
    }
}
