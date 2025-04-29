package logsystem;

public interface LogAppender {
    void append(LogLevel level, String message);
}
