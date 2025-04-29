package logsystem;

public class DataBaseAppender implements LogAppender{
    @Override
    public void append(LogLevel level, String message) {
        //append on database
        System.out.println("Appending to database: " + message);
    }
}
