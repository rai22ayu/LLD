package logsystem;

public class LoggerFactory {

    public static LogProcessor getLogProcessor(LogLevel logLevel){
        LogProcessor logProcessor = null;
        LogProcessor infoProcessor = InfoProcessor.getInstance();
        LogProcessor debugProcessor = DebugProcessor.getInstance();
        LogProcessor traceProcessor = TraceProcessor.getInstance();
        switch (logLevel) {
            case INFO -> logProcessor = infoProcessor;
            case DEBUG -> logProcessor = debugProcessor;
            case TRACE -> logProcessor = traceProcessor;
        }
        return logProcessor;
    }
}
