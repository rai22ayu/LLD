package logsystem;

public class InfoProcessor extends LogProcessor{
    private static LogProcessor instance = null;

    private InfoProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor, LogLevel.INFO, new ConsoleAppender());
    }

    public void log(LogLevel logLevel, String message) {
        if (logLevel == level) {
            System.out.println("[INFO]: " + message);
            logAppender.append(logLevel, message);
        } else if (nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }

    public static LogProcessor getInstance(){
        if(instance == null){
            instance = new InfoProcessor(null);
        }
        return instance;
    }
}
