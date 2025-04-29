package logsystem;

public class LoggerMain {
    public static void main(String... args){
        LogProcessor logger = LoggerFactory.getLogProcessor(LogLevel.INFO);
        logger.setLogAppender(new ConsoleAppender());
        logger.log(LogLevel.INFO, "Info message");
        logger.log(LogLevel.DEBUG, "Debug message");
        logger.log(LogLevel.TRACE, "Trace message");

    }
}
