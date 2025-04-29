package logsystem;

public class DebugProcessor extends LogProcessor{
    private static LogProcessor instance = null;

    private DebugProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor, LogLevel.DEBUG, new ConsoleAppender());
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel == level) {
            System.out.println("[Debug]: " + message);
            logAppender.append(logLevel, message);
        } else if (nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }
    public static LogProcessor getInstance(){
        if(instance == null){
            instance = new DebugProcessor(InfoProcessor.getInstance());
        }
        return instance;
    }
}
