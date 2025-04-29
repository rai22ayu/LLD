package logsystem;

public class TraceProcessor extends LogProcessor{
    private static LogProcessor instance = null;

    private TraceProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor, LogLevel.TRACE, new ConsoleAppender());
    }

    public void log(LogLevel logLevel, String message) {
        if (logLevel == level) {
            System.out.println("[Trace]: " + message);
            logAppender.append(logLevel, message);
        } else if (nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }

    public static LogProcessor getInstance(){
        if(instance == null){
            instance = new TraceProcessor(DebugProcessor.getInstance());
        }
        return instance;
    }

}
