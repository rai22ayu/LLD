package logsystem;

public class FileAppender implements LogAppender{
    @Override
    public void append(LogLevel level, String message) {
        System.out.println("Appending to file: " + message);
        //File append logic
    }
}
