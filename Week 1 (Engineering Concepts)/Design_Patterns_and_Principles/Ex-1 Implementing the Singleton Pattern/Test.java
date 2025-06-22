public class Test
{
    public static void main(String[] args)
    {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");

        // Verifying if both references point to the same object
        if(logger1 == logger2)
        {
            System.out.println("Success. Both logger instances are the same. Only one logger instance exists.");
        }
        else
        {
            System.out.println("Failure. Logger instances are different. Multiple logger instance exists.");
        }
    }
}
