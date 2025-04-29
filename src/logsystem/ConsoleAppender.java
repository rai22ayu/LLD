package logsystem;

public class ConsoleAppender implements LogAppender{
    @Override
    public void append(LogLevel level, String message) {
        //append on console
        System.out.println("Appending to console: " + message);
    }
}
