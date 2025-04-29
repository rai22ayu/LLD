package logsystem;

public abstract class LogProcessor {
    protected final LogProcessor nextLogProcessor;
    protected final LogLevel level;
    protected LogAppender logAppender;

    public LogProcessor(LogProcessor nextLogProcessor, LogLevel level, LogAppender logAppender) {
        this.nextLogProcessor = nextLogProcessor;
        this.level = level;
        this.logAppender = logAppender;
    }

    public void setLogAppender(LogAppender logAppender){
        LogProcessor lp = this;
        while(lp != null){
            lp.logAppender = logAppender;
            lp = lp.nextLogProcessor;
        }
    }

    public abstract void log(LogLevel level, String message);
}

